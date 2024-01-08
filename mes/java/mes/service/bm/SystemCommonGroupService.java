package mes.service.bm;

import java.util.List;
import mes.domain.bm.SystemCommonGroupVo;

public interface SystemCommonGroupService {
	
	//시스템공통그룹 전체조회
	public List<SystemCommonGroupVo> listAll() throws Exception;

	//시스템공통그룹 특정 Read
	public SystemCommonGroupVo read(SystemCommonGroupVo Vo) throws Exception;
	
	//시스템공통그룹 Create
	public void create(SystemCommonGroupVo Vo) throws Exception;
	
	//시스템공통그룹 Update
	public void update(SystemCommonGroupVo Vo) throws Exception;
}
