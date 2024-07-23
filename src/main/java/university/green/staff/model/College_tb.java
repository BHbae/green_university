package university.green.staff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 등록 -> 단과대학 DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class College_tb {

	private int id;
	private String name;
	
}
