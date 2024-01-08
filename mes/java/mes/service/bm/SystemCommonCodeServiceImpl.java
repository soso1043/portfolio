package mes.service.bm;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import mes.domain.bm.SystemCommonCodeVo;
import mes.persistence.bm.SystemCommonCodeDAO;

@Service
public class SystemCommonCodeServiceImpl implements SystemCommonCodeService {

	@Inject
	private SystemCommonCodeDAO dao;

	//시스템공통코드 전체조회
	@Override
	public List<SystemCommonCodeVo> listAll(SystemCommonCodeVo Vo) throws Exception {
		return dao.listAll(Vo);
	}

	//시스템공통코드 특정 Read
	@Override
	public SystemCommonCodeVo read(SystemCommonCodeVo Vo) throws Exception {
		return dao.read(Vo);
	}
	
	//시스템공통그룹 Create
	@Override
	public void create(SystemCommonCodeVo Vo) throws Exception {
		dao.create(Vo);
	}
	
	//시스템공통코드 Update
	@Override
	public void update(SystemCommonCodeVo Vo) throws Exception {
		dao.update(Vo);
	}


}
