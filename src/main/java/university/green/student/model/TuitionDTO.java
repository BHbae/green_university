package university.green.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


// 등록금 DTO

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TuitionDTO {
	private int student_id;
	private int tui_year;
	private int tui_amount;
	private int sch_type;
	private int sch_amount;
	private int status;
}
