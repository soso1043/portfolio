package mes.persistence.bm;

import java.util.List;
import mes.domain.bm.EquipCodeAdmVo;

public interface EquipCodeAdmDAO {
	
	//설비코드 전체조회
	public List<EquipCodeAdmVo> listAll() throws Exception;
	
	//설비코드 특정 Read
	public EquipCodeAdmVo read(EquipCodeAdmVo Vo) throws Exception;

	//설비코드 Create
	public void create(EquipCodeAdmVo Vo) throws Exception;
	
	//설비코드 Update
	public void update(EquipCodeAdmVo Vo) throws Exception;
	
}