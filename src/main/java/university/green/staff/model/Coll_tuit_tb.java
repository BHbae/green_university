package university.green.staff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 등록 -> 단대별 등록금 DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Coll_tuit_tb {
	
	private int collegeId;
	private int amount;

}
