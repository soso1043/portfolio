package mes.persistence.bm;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mes.domain.bm.SystemCommonGroupVo;

@Repository
public class SystemCommonGroupDAOImpl implements SystemCommonGroupDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "mes.mappers.bm.systemCommonGroupMapper";
	
	//시스템공통그룹 전체조회
	@Override
	public List<SystemCommonGroupVo> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}
	
	//시스템공통그룹 특정 Read
	@Override
	public SystemCommonGroupVo read(SystemCommonGroupVo Vo) throws Exception{
		return session.selectOne(namespace+".read", Vo);
	}
	
	//시스템공통그룹 Create
	@Override
	public void create(SystemCommonGroupVo Vo) throws Exception{
		session.insert(namespace+".create", Vo);
	}
	
	//시스템공통그룹 Update
	@Override
	public void update(SystemCommonGroupVo Vo) throws Exception{
		session.update(namespace+".update", Vo);
	}
}