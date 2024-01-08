package mes.persistence.user;

import java.util.List;

import mes.domain.UserVo;


public interface UserDAO {
	String create(UserVo vo) throws Exception;

	UserVo read(UserVo vo) throws Exception;

	void update(UserVo vo) throws Exception;

	List<UserVo> all(UserVo vo) throws Exception;
}
