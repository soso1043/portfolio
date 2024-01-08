package mes.web.bm;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mes.domain.bm.MatrlCodeAdmVo;
import mes.domain.bm.SystemCommonCodeVo;
import mes.service.bm.MatrlCodeAdmService;
import mes.service.bm.SystemCommonCodeService;

@Controller
public class MatrlCodeAdmController {

	@Inject
	private MatrlCodeAdmService matrlCodeAdmService;
	
	@Inject
	private SystemCommonCodeService systemCommonCodeService;	
	
	private static final Logger logger = LoggerFactory.getLogger(MatrlCodeAdmService.class);

	//자재코드관리 메인
	@RequestMapping(value = "/bmsc0060", method = RequestMethod.GET)
	public String matrlCdAdmMain(Locale locale, Model model) throws Exception {
		
		logger.info("자재코드관리 메인");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		SystemCommonCodeVo systemCommonCodeVo = new SystemCommonCodeVo();
		
		systemCommonCodeVo.setBaseGroupCd("001"); // 재질
		List<SystemCommonCodeVo>  systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("qutyCd", systemCommonCodeList );

		systemCommonCodeVo.setBaseGroupCd("002"); // 구분(연질/경질)
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("gubunCd", systemCommonCodeList );
		
		systemCommonCodeVo.setBaseGroupCd("003"); // 면취(압연)
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("chamferYnCd", systemCommonCodeList );
		
		systemCommonCodeVo.setBaseGroupCd("004"); // 표면처리
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("surfaceTrtmtCd", systemCommonCodeList );		
		
		systemCommonCodeVo.setBaseGroupCd("005"); // 생산단위
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("productUnitCd", systemCommonCodeList );
		
		systemCommonCodeVo.setBaseGroupCd("006"); // 재고단위
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("tmUnitCd", systemCommonCodeList );
		
		systemCommonCodeVo.setBaseGroupCd("007"); // 상태유뮤
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("statusYnCd", systemCommonCodeList );
		
		return "bm/bmsc0060";
	}

	//자재코드관리 목록조회
	@RequestMapping(value = "/bm/matrlCdDataList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> matrlCdDataList(MatrlCodeAdmVo matrlCodeAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("자재코드관리 목록조회");
		List<MatrlCodeAdmVo> matrlCodeAdmData = matrlCodeAdmService.listAll(matrlCodeAdmVo);
		jsonData.put("data", matrlCodeAdmData);
		
		return jsonData;
	}
	
	//자재코드관리 상세조회
	@RequestMapping(value = "/bm/matrlCdData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> matrlCdData(MatrlCodeAdmVo matrlCodeAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("자재코드관리 상세조회");
		matrlCodeAdmVo = matrlCodeAdmService.read(matrlCodeAdmVo);
		jsonData.put("data", matrlCodeAdmVo);
		
		return jsonData;
	}

	//자재코드관리 등록
	@RequestMapping(value = "/bm/matrlCdCreate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> matrlCdCreate(MatrlCodeAdmVo matrlCodeAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("자재코드관리 등록");
		String matrlCd = matrlCodeAdmService.selectMatrlSeqCd();
		String preMatrlCd = "A";
		
		if( "002".equals(matrlCodeAdmVo.getQutyCd()) ) {
			preMatrlCd = "N";	//Nicu
		} else if( "003".equals(matrlCodeAdmVo.getQutyCd()) ) {
			preMatrlCd = "F";	//Film
		}
		
		matrlCd = preMatrlCd.concat(matrlCd);
		matrlCodeAdmVo.setMatrlCd(matrlCd);

		matrlCodeAdmService.create(matrlCodeAdmVo);
		jsonData.put("data", matrlCodeAdmVo);
		jsonData.put("result", "ok");
		
		return jsonData;
	}
	
	//자재코드관리 수정
	@RequestMapping(value = "/bm/matrlCdUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> matrlCdUpdate(MatrlCodeAdmVo matrlCodeAdmVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("자재코드관리 수정");
		matrlCodeAdmService.update(matrlCodeAdmVo);
		jsonData.put("data", matrlCodeAdmVo);
		jsonData.put("result", "ok");		
		return jsonData;
	}	


	//자재코드관리 목록팝업
	@RequestMapping(value = "/cmsc0050", method = RequestMethod.GET)
	public String matrlCdAdmPop(HttpServletRequest request, Locale locale, Model model) throws Exception {
		
		logger.info("자재코드관리 목록팝업");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		String matrlQuty = request.getParameter("qutyType");
		model.addAttribute("matrlQuty", matrlQuty );
		return "cm/cmsc0050";
	}
	
//			@Inject
//			private MatrlCodeAdmService service;	
//
//		
//			//초기 home
//			@RequestMapping(value="/bmsc0060", method = RequestMethod.GET)
//			public ModelAndView bmsc0060GET(ModelAndView mav) throws Exception {
//				mav.setViewName("bm/bmsc0060");
//				return mav;
//			}
//			@RequestMapping(value="/bmsc0060_1", method = RequestMethod.GET)
//			public ModelAndView main2GET(ModelAndView mav) throws Exception {
//				mav.setViewName("bm/bmsc0060_1");
//				return mav;
//			}
//			
//			
//			@ResponseBody
//			@RequestMapping(value="/save", method = RequestMethod.POST)
//			public void savePOST(ModelAndView mav, MatrlCodeAdmVo vo) throws Exception {
//				if(vo.getMatrlNm().toString() != null) {
//					if(service.read(vo)==null) {
//						vo.setRegId("ddd");
//						service.create(vo);			
//						System.out.println(vo.getMatrlNm().toString());					
//					} else {
//						vo.setUpdId("aaa");
//						service.update(vo);
//					}				
//				}			
//			}
//				
//			@RequestMapping(value = "/data", method = RequestMethod.GET)
//			public @ResponseBody
//			Map<String, Object> dataGET() throws Exception {
//				Map<String, Object> jsonData = new HashMap<String, Object>();
//							
//				List<MatrlCodeAdmVo> codeList = service.all();
//
//				System.out.println(codeList);
//				jsonData.put("data", codeList);
//				return jsonData;			
//			}	
//			
//				
//			@RequestMapping(value = "/sideData", method = RequestMethod.POST)
//			public @ResponseBody
//			MatrlCodeAdmVo sideData(MatrlCodeAdmVo vo) throws Exception {			 						
//				vo = service.read(vo);						
//				return vo;
//			}
//			
//		
//					
}

