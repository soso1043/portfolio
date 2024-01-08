package mes.domain;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserVo extends CommonVo {
	// 사용자 정보
	private String userId;			// 사원번호
	private String password;		// 비밀번호
	private String name;			// 이름
	private String phone;			// 사무실 전화번호
	private String rankIdx;			// 직급 idx
	private String departmentIdx;	// 부서 idx
	private String loggedInIp;		// 로그인 IP
	private Date loggedInAt;		// 로그인 시간

	// 추가
	private String rank;			// 직급
	private String department;		// 부서
}
