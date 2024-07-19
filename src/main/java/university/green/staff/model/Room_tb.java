package university.green.staff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 등록 -> 강의실 DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Room_tb {

	private String id;
	private int collegeId;
	
}
