package university.green.staff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 등록 -> 학과 DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Department_tb {
	private int id;
	private String name;
	private int collegeId;

}
