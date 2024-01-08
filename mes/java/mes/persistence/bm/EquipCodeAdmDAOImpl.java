package mes.persistence.bm;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import mes.domain.bm.EquipCodeAdmVo;

@Repository
public class EquipCodeAdmDAOImpl implements EquipCodeAdmDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "mes.mappers.bm.equipCodeAdmMapper";
	
	//설비코드 전체조회
	@Override
	public List<EquipCodeAdmVo> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}

	//설비코드 특정 Read
	public EquipCodeAdmVo read(EquipCodeAdmVo Vo) throws Exception{
		return session.selectOne(namespace+".read", Vo);
	}
	
	
	//설비코드 Create
	@Override
	public void create(EquipCodeAdmVo Vo) throws Exception{
		session.insert(namespace+".create", Vo);
	}
	
	//설비코드 Update
	@Override
	public void update(EquipCodeAdmVo Vo) throws Exception{
		session.update(namespace+".update", Vo);
	}
	
}