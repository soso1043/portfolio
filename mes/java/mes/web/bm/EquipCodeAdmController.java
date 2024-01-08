package mes.web.bm;

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
import mes.domain.bm.EquipCodeAdmVo;
import mes.domain.bm.SystemCommonCodeVo;
import mes.service.bm.EquipCodeAdmService;
import mes.service.bm.SystemCommonCodeService;

@Controller
public class EquipCodeAdmController {
	
	@Inject
	private EquipCodeAdmService equipCodeAdmService;
	@Inject
	private SystemCommonCodeService systemCommonCodeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EquipCodeAdmController.class);
	
	//설비코드관리 페이지
	@RequestMapping(value = "/bmsc0030", method = RequestMethod.GET)
	public String bmsc0030GET(Locale locale, Model model) throws Exception {
		
		logger.info("설비코드관리 메인");
		SystemCommonCodeVo systemCommonCodeVo = new SystemCommonCodeVo();
		
		systemCommonCodeVo.setBaseGroupCd("007"); // 재질
		List<SystemCommonCodeVo>  systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("statusYnCd", systemCommonCodeList );

		systemCommonCodeVo.setBaseGroupCd("008"); // 설치 장소
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("installLocation", systemCommonCodeList );
		
		systemCommonCodeVo.setBaseGroupCd("009"); // 설비 분류
		systemCommonCodeList = systemCommonCodeService.listAll(systemCommonCodeVo);
		model.addAttribute("equipCtrgy", systemCommonCodeList );
		
		return "bm/bmsc0030";
	}
	
	//설비코드 전체 조회
	@RequestMapping(value = "/bm/equipCodeAdmDataList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> systemCommonGroupDataListGET() throws Exception {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		logger.info("설비정보관리 전제 조회");
		List<EquipCodeAdmVo> equipCodeAdmVoList= equipCodeAdmService.listAll();
		jsonData.put("data", equipCodeAdmVoList);
		return jsonData;
	}

	//설비코드 클릭 Read
	@RequestMapping(value = "/bm/equipCodeAdmView", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> equipCodeAdmViewGET(EquipCodeAdmVo equipCodeAdmVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("검색 전 : "+equipCodeAdmVo);
		equipCodeAdmVo = equipCodeAdmService.read(equipCodeAdmVo);
		System.out.println("검색 후 : "+equipCodeAdmVo);
		jsonData.put("data", equipCodeAdmVo);
		return jsonData;
	}
	
	
	//설비코드 Create
	@RequestMapping(value = "/bm/equipCodeAdmCreate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> systemCommonGroupCreatePOST(EquipCodeAdmVo equipCodeAdmVo, HttpServletRequest request) throws Exception {
		
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("받은값: " + equipCodeAdmVo);
		equipCodeAdmService.create(equipCodeAdmVo);
		equipCodeAdmVo = equipCodeAdmService.read(equipCodeAdmVo);
		System.out.println("equipCodeAdm 생성 완료 : "+equipCodeAdmVo);
		jsonData.put("data", equipCodeAdmVo);
		jsonData.put("result", "ok");

		return jsonData;
	}
	
	//설비코드 Update
	@RequestMapping(value = "/bm/equipCodeAdmUpdate", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> systemCommonGroupUpdatePOST (EquipCodeAdmVo equipCodeAdmVo) throws Exception {
		Map<String, Object> jsonData = new HashMap<>();
		System.out.println("수정 전 : "+equipCodeAdmVo);
		equipCodeAdmService.update(equipCodeAdmVo);
	    equipCodeAdmVo = equipCodeAdmService.read(equipCodeAdmVo);
	    jsonData.put("data", equipCodeAdmVo);
	    System.out.println("수정 완료(시스템공통그룹) : "+equipCodeAdmVo);
	    jsonData.put("result", "ok");
		return jsonData;
	}
	

	 
}