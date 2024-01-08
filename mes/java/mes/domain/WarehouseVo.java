package mes.domain;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class WarehouseVo extends CommonVo {
	// 창고 정보
	private String name;			// 창고 이름
	private String location;		// 창고 위치
}
