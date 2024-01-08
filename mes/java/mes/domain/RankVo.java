package mes.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RankVo extends CommonVo {
	// 직급 정보
	private String rank;		// 직급
}
