package university.green.staff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 등록 -> 강의 DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Subject_tb {

	private int id;
	private String name;
	private int professorId;
	private String roomId;
	private int deptId;
	private String type;
	private int subYear;
	private int semester;
	private String subDay;
	private int startTime;
	private int endTime;
	private int grades;
	private int capacity;
	private int numOfStudent;
	
}
