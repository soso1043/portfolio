package mes.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DepartmentVo extends CommonVo {
	// 부서 정보
	private String department;		// 부서
}
