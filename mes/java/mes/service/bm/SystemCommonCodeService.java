package mes.service.bm;

import java.util.List;
import mes.domain.bm.SystemCommonCodeVo;

public interface SystemCommonCodeService {
	
	//시스템공통코드 전체조회
	public List<SystemCommonCodeVo> listAll(SystemCommonCodeVo Vo) throws Exception;

	//시스템공통코드 특정 Read
	public SystemCommonCodeVo read(SystemCommonCodeVo Vo) throws Exception;
	
	//시스템공통코드 Create
	public void create(SystemCommonCodeVo Vo) throws Exception;
	
	//시스템공통코드 Update
	public void update(SystemCommonCodeVo Vo) throws Exception;
	
}
