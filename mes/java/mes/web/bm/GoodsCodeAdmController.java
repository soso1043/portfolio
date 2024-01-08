package mes.web.bm;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mes.domain.bm.GoodsCodeAdmVo;
import mes.domain.bm.MatrlCodeAdmVo;
import mes.domain.bm.SystemCommonCodeVo;
import mes.service.bm.GoodsCodeAdmService;
import mes.service.bm.MatrlCodeAdmService;
import mes.service.bm.SystemCommonCodeService;

@Controller
public class GoodsCodeAdmController {
	@Inject
	private GoodsCodeAdmService goodsCodeAdmService;
	
	@Inject
	private SystemCommonCodeService systemCommonCodeService;
	
	@Inject
	private MatrlCodeAdmService matrlCodeAdmService;	
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsCodeAdmController.class);

	//제품코드관리 메인
	@RequestMapping(value = "/bmsc0010", method = RequestMethod.GET)
	public String goodsCodeAdmMain(Locale locale, Model model) throws Exception {
		logger.info("제품코드관리 메인");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		SystemCommonCodeVo systemCommonCodeVo = new SystemCommonCodeVo();
		
		systemCommonCodeVo.setBaseGroupCd("007"); // 상태유무
		List<SystemCommonCodeVo>  systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("statusYnCd", systemCommonCodeList );		
		
		systemCommonCodeVo.setBaseGroupCd("006"); // 재고단위
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("tmUnitCd", systemCommonCodeList );		

		systemCommonCodeVo.setBaseGroupCd("011"); // 포장단위
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("packUnitCd", systemCommonCodeList );
		
		return "bm/bmsc0010";
	}

	//제품코드관리 목록조회
	@RequestMapping(value = "/bm/goodsCodeDataList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> goodsCodeDataList(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("제품코드관리 목록조회");
		List<GoodsCodeAdmVo> goodsCodeDataList = goodsCodeAdmService.listAll();
		jsonData.put("data", goodsCodeDataList);
		return jsonData;
	}
	
	//제품코드관리 목록조회
	@RequestMapping(value = "/bm/goodsCodeData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> goodsCodeData(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("제품코드관리 상세조회");
		goodsCodeAdmVo = goodsCodeAdmService.read(goodsCodeAdmVo);
		jsonData.put("data", goodsCodeAdmVo);
		
		// Al/Nicu 자재정보 상세조회
		MatrlCodeAdmVo alniMatrlCodeAdmVo = new MatrlCodeAdmVo();
		alniMatrlCodeAdmVo.setMatrlCd(goodsCodeAdmVo.getAlnicuMatrlCd());
		alniMatrlCodeAdmVo = matrlCodeAdmService.read(alniMatrlCodeAdmVo);
		jsonData.put("alnidata", alniMatrlCodeAdmVo);

		// Film 자재정보 상세조회
		MatrlCodeAdmVo filmMatrlCodeAdmVo = new MatrlCodeAdmVo();		
		filmMatrlCodeAdmVo.setMatrlCd(goodsCodeAdmVo.getFilmMatrlCd());
		filmMatrlCodeAdmVo = matrlCodeAdmService.read(filmMatrlCodeAdmVo);
		jsonData.put("filmdata", filmMatrlCodeAdmVo);
		
		return jsonData;
	}
	
	//제품코드관리 등록
	@RequestMapping(value = "/bm/goodsCdCreate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> goodsCdCreate(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("제품코드관리 등록");
		
		String goodsCd = goodsCodeAdmService.selectGoodsSeqCd();
		String preGoodsCd = goodsCodeAdmVo.getAlnicuMatrlCd().substring(0, 1);
		goodsCd = preGoodsCd.concat(goodsCd);
		goodsCodeAdmVo.setGoodsCd(goodsCd);

		goodsCodeAdmService.create(goodsCodeAdmVo);
		jsonData.put("data", goodsCodeAdmVo);
		jsonData.put("result", "ok");
		
		return jsonData;
	}
	
	//제품코드관리 수정
	@RequestMapping(value = "/bm/goodsCdUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> goodsCdUpdate(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("제품코드관리 수정");
		goodsCodeAdmService.update(goodsCodeAdmVo);
		jsonData.put("data", goodsCodeAdmVo);
		jsonData.put("result", "ok");		
		return jsonData;
	}		
	
}
