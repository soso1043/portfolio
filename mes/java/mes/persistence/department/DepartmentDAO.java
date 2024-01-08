package mes.persistence.department;

import java.util.List;

import mes.domain.DepartmentVo;


public interface DepartmentDAO {
	String create(DepartmentVo vo) throws Exception;

	DepartmentVo read(DepartmentVo vo) throws Exception;

	void update(DepartmentVo vo) throws Exception;

	List<DepartmentVo> all(DepartmentVo vo) throws Exception;
}
