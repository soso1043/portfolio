package mes.persistence.rank;

import java.util.List;

import mes.domain.RankVo;


public interface RankDAO {
	String create(RankVo vo) throws Exception;

	RankVo read(RankVo vo) throws Exception;

	void update(RankVo vo) throws Exception;

	List<RankVo> all(RankVo vo) throws Exception;
}
