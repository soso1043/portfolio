package mes.persistence.user;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mes.domain.UserVo;


@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "user";

	@Override
	public String create(UserVo vo) throws Exception {
		if (vo.getIdx() == null) {
			String uuid = UUID.randomUUID().toString();
			vo.setIdx(uuid);
		}
		session.insert(namespace + ".create", vo);
		return vo.getIdx();
	}

	@Override
	public UserVo read(UserVo vo) throws Exception {
		return session.selectOne(namespace + ".read", vo);
	}

	@Override
	public void update(UserVo vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public List<UserVo> all(UserVo vo) throws Exception {
		return session.selectList(namespace + ".all", vo);
	}
}
