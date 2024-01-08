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

import mes.domain.bm.DealCorpAdmVo;
import mes.domain.bm.SystemCommonCodeVo;
import mes.service.bm.DealCorpAdmService;
import mes.service.bm.SystemCommonCodeService;

@Controller
public class DealCorpAdmController {
	@Inject
	private DealCorpAdmService dealCorpAdmService;
	
	@Inject
	private SystemCommonCodeService systemCommonCodeService;	
	
	private static final Logger logger = LoggerFactory.getLogger(DealCorpAdmController.class);

	//거래처정보관리 메인
	@RequestMapping(value = "/bmsc0020", method = RequestMethod.GET)
	public String dealCorpAdmMain(Locale locale, Model model) throws Exception {
		
		logger.info("거래처정보관리 메인");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		SystemCommonCodeVo systemCommonCodeVo = new SystemCommonCodeVo();
		
		systemCommonCodeVo.setBaseGroupCd("007"); // 상태유무
		List<SystemCommonCodeVo>  systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		jsonData.put("useYnCd", systemCommonCodeList);
		
		model.addAttribute("useYnCd", systemCommonCodeList );
		model.addAttribute("useYnCdJson", jsonData );
		return "bm/bmsc0020";
	}

	//거래처정보관리 목록조회
	@RequestMapping(value = "/bm/dealCorpDataList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> dealCorpDataList(DealCorpAdmVo dealCorpAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("거래처정보관리 목록조회");
		List<DealCorpAdmVo> dealCorpAdmData = dealCorpAdmService.listAll();
		jsonData.put("data", dealCorpAdmData);
		
		return jsonData;
	}
	
	//거래처정보관리 상세조회
	@RequestMapping(value = "/bm/dealCorpData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> dealCorpData(DealCorpAdmVo dealCorpAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("거래처정보관리 상세조회");
		dealCorpAdmVo = dealCorpAdmService.read(dealCorpAdmVo);
		jsonData.put("data", dealCorpAdmVo);
		
		return jsonData;
	}

	//거래처정보관리 등록
	@RequestMapping(value = "/bm/dealCorpCreate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> dealCorpCreate(DealCorpAdmVo dealCorpAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("거래처정보관리 등록");
		String dealCorpCd = dealCorpAdmService.selectDealCorpSeqCd();
		dealCorpAdmVo.setDealCorpCd(dealCorpCd);
		dealCorpAdmService.create(dealCorpAdmVo);
		jsonData.put("data", dealCorpAdmVo);
		jsonData.put("result", "ok");		
		return jsonData;
	}
	
	//거래처정보관리 수정
	@RequestMapping(value = "/bm/dealCorpUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> dealCorpUpdate(DealCorpAdmVo dealCorpAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("거래처정보관리 수정");
		dealCorpAdmService.update(dealCorpAdmVo);
		jsonData.put("data", dealCorpAdmVo);
		jsonData.put("result", "ok");		
		return jsonData;
	}
	
	//거래처정보관리 메인
	@RequestMapping(value = "/cmsc0020", method = RequestMethod.GET)
	public String dealCorpAdmPop(Locale locale, Model model) throws Exception {
		
		logger.info("거래처정보관리 팝업");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		return "cm/cmsc0020";
	}	
		
}
