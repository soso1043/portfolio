package mes.domain.bm;

import java.util.Date;
import lombok.Data;

@Data
public class SystemCommonGroupVo {

	private String baseGroupCd;		//기초그룹코드
	private String baseGroupCdNm;	//기초그룹코드명
	private String baseGroupCdDesc;	//기초그룹코드상세
	private String useYn;			//사용유무	    Y:사용, N:미사용
	private String regId;			//등록자
	private Date regDate;			//등록일
	private String updId;			//수정자
	private Date updDate;			//수정일

}