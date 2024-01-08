package mes.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class CommonVo {
	// 정보
	private String idx;					// 식별키
	private String deleted;				// 삭제, 삭제안함

	// 등록, 수정, 삭제
	private String createdBy;			// 등록한 사용자 idx
	private String updatedBy;			// 수정한 사용자 idx
	private String deletedBy;			// 삭제한 사용자 idx
	private Date createdAt;				// 등록 일시
	private Date updatedAt;				// 수정 일시
	private Date deletedAt;				// 삭제 일시

	// 추가
	private String createdName;			// 등록한 사용자 이름
	private String updatedName;			// 수정한 사용자 이름
	private String deletedName;			// 삭제한 사용자 이름

	// 검색
	private String searchCode;			// 코드번호
	private String searchStartDate;		// 시작날짜
	private String searchEndDate;		// 종료날짜
}
