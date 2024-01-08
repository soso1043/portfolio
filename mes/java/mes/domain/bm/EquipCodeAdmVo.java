package mes.domain.bm;

import java.util.Date;
import lombok.Data;

@Data
public class EquipCodeAdmVo {
	
	private String equipCd;			//설비코드
	private String equipNm;         //설비명
	private String equipCtrgy;      //설비분류
	private String modelNm;         //모델명
	private String manufactr;       //제조업체
	private String buyCorp;         //구입업체
	private String buyDate;         //구매일
	private String voltage;         //전압
	private String pressure;        //공압
	private String telNo;           //전화번호
	private String faxNo;           //팩스번호
	private String installLocation; //설치장소
	private String capa;            //Capa(용량)
	private String etc1;            //체크1
	private String etc2;            //체크2
	private String useYn;           //사용여부
	private String dealCorpDesc;    //비고
	private String regId;           //등록자
	private Date regDate;           //등록일
	private String updId;           //수정자
	private Date updDate;           //수정일

}