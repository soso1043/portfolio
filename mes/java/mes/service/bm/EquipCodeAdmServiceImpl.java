package mes.service.bm;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import mes.domain.bm.EquipCodeAdmVo;
import mes.persistence.bm.EquipCodeAdmDAO;

@Service
public class EquipCodeAdmServiceImpl implements EquipCodeAdmService {

	@Inject
	private EquipCodeAdmDAO dao;
	
	//설비코드 전체조회
	@Override
	public List<EquipCodeAdmVo> listAll() throws Exception {
		return dao.listAll();
	}

	//설비코드 특정 Read
	@Override
	public EquipCodeAdmVo read(EquipCodeAdmVo Vo) throws Exception {
		return dao.read(Vo);
	}
	
	//설비코드 Create
	@Override
	public void create(EquipCodeAdmVo Vo) throws Exception {
		dao.create(Vo);
	}
	
	//설비코드 Update
	@Override
	public void update(EquipCodeAdmVo Vo) throws Exception {
		dao.update(Vo);
	}
	
}
