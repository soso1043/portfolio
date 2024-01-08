package mes.persistence.department;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mes.domain.DepartmentVo;


@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "department";

	@Override
	public String create(DepartmentVo vo) throws Exception {
		if (vo.getIdx() == null) {
			String uuid = UUID.randomUUID().toString();
			vo.setIdx(uuid);
		}
		session.insert(namespace + ".create", vo);
		return vo.getIdx();
	}

	@Override
	public DepartmentVo read(DepartmentVo vo) throws Exception {
		return session.selectOne(namespace + ".read", vo);
	}

	@Override
	public void update(DepartmentVo vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public List<DepartmentVo> all(DepartmentVo vo) throws Exception {
		return session.selectList(namespace + ".all", vo);
	}
}
