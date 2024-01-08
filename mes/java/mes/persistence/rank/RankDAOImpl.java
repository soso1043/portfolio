package mes.persistence.rank;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mes.domain.RankVo;


@Repository
public class RankDAOImpl implements RankDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "rank";

	@Override
	public String create(RankVo vo) {
		if (vo.getIdx() == null) {
			String uuid = UUID.randomUUID().toString();
			vo.setIdx(uuid);
		}
		session.insert(namespace + ".create", vo);
		return vo.getIdx();
	}

	@Override
	public RankVo read(RankVo vo) {
		return session.selectOne(namespace + ".read", vo);
	}

	@Override
	public void update(RankVo vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public List<RankVo> all(RankVo vo) {
		return session.selectList(namespace + ".all", vo);
	}
}
