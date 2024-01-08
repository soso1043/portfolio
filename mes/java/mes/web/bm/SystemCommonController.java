package mes.web.bm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mes.domain.bm.SystemCommonCodeVo;
import mes.domain.bm.SystemCommonGroupVo;
import mes.service.bm.SystemCommonCodeService;
import mes.service.bm.SystemCommonGroupService;

@Controller
//@RequestMapping("/bm/bmsc0050")
public class SystemCommonController {
	
	@Inject
	private SystemCommonGroupService systemCommonGroupService;
	@Inject
	private SystemCommonCodeService systemCommonCodeService;
	
	private static final Logger logger = LoggerFactory.getLogger(SystemCommonController.class);
	
	//시스템공통정보 페이지
	@RequestMapping(value = "/bmsc0050", method = RequestMethod.GET)
	public ModelAndView sc0050GET(ModelAndView mav) throws Exception {
		logger.info("bm/bmsc0050(GET) 시스템공통정보 페이지");
    	mav.setViewName("bm/bmsc0050"); 
		return mav;
	}	

	//시스템공통그룹 전체조회
	@RequestMapping(value = "/systemCommonGroupDataList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> systemCommonGroupDataListGET(SystemCommonGroupVo systemCommonGroupVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("시스템공통그룹 전제조회");
		List<SystemCommonGroupVo> systemCommonGroupList = systemCommonGroupService.listAll();
		jsonData.put("data", systemCommonGroupList);
		return jsonData;
	}
	
	//시스템공통코드 전체조회
	@RequestMapping(value = "/systemCommonCodeDataList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> systemCommonCodeDataListGET(SystemCommonCodeVo systemCommonCodeVo) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("시스템공통코드 전제조회");
		//System.out.println("systemCommonCodeVo : "+systemCommonCodeVo);
		List<SystemCommonCodeVo> systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		jsonData.put("data", systemCommonCodeList);
		return jsonData;
	}
	
	//시스템공통그룹 클릭 Read
	@RequestMapping(value = "/systemCommonGroupView", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> systemCommonGroupViewGET(SystemCommonGroupVo systemCommonGroupVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		//System.out.println("검색 전 : "+systemCommonGroupVo);
		systemCommonGroupVo = systemCommonGroupService.read(systemCommonGroupVo);
		//System.out.println("검색 후 : "+systemCommonGroupVo);
		jsonData.put("data", systemCommonGroupVo);
		return jsonData;
	}
	
	//시스템공통그룹 Create
	@RequestMapping(value = "/systemCommonGroupCreate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> systemCommonGroupCreatePOST(SystemCommonGroupVo systemCommonGroupVo, HttpServletRequest request) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<>();
		systemCommonGroupService.create(systemCommonGroupVo);
		systemCommonGroupVo = systemCommonGroupService.read(systemCommonGroupVo);
		System.out.println("systemCommonGroup 생성 완료 : "+systemCommonGroupVo);
		jsonData.put("data", systemCommonGroupVo);
		jsonData.put("result", "ok");

		return jsonData;
	}
	
	//시스템공통그룹 Update
	@RequestMapping(value = "/systemCommonGroupUpdate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> systemCommonGroupUpdatePOST (SystemCommonGroupVo systemCommonGroupVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("수정 전 : "+systemCommonGroupVo);
	    systemCommonGroupService.update(systemCommonGroupVo);
	    systemCommonGroupVo = systemCommonGroupService.read(systemCommonGroupVo);
	    jsonData.put("data", systemCommonGroupVo);
	    System.out.println("수정 완료(시스템공통그룹) : "+systemCommonGroupVo);
	    jsonData.put("result", "ok");
		return jsonData;
	}
	
	//시스템공통코드 클릭 Read
	@RequestMapping(value = "/systemCommonCodeView", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> systemCommonCodeViewGET(SystemCommonCodeVo systemCommonCodeVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("검색 전 : "+systemCommonCodeVo);
		systemCommonCodeVo = systemCommonCodeService.read(systemCommonCodeVo);
		System.out.println("검색 후 : "+systemCommonCodeVo);
		jsonData.put("data", systemCommonCodeVo);
		return jsonData;
	}
	
	//시스템공통코드 Create
	@RequestMapping(value = "/systemCommonCodeCreate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> systemCommonCodeCreatePOST(SystemCommonCodeVo systemCommonCodeVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("코드 등록 전 받은값 : "+systemCommonCodeVo);
		systemCommonCodeService.create(systemCommonCodeVo);
		systemCommonCodeVo = systemCommonCodeService.read(systemCommonCodeVo);
		System.out.println("코드 등록 완료 : "+systemCommonCodeVo);
		jsonData.put("data", systemCommonCodeVo);
		jsonData.put("result", "ok");
		return jsonData;
	}
	
	//시스템공통코드 Update
	@RequestMapping(value = "/systemCommonCodeUpdate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> systemCommonCodeUpdatePOST (SystemCommonCodeVo systemCommonCodeVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("수정 전 : "+systemCommonCodeVo);
	    systemCommonCodeService.update(systemCommonCodeVo);
	    systemCommonCodeVo = systemCommonCodeService.read(systemCommonCodeVo);
	    jsonData.put("data", systemCommonCodeVo);
	    System.out.println("수정 완료(시스템코드 그룹) : "+systemCommonCodeVo);
	    jsonData.put("result", "ok");
		return jsonData;
	}
	
}