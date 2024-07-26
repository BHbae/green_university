package university.green.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StuSchDTO {

	// 학생-등록금 정보
	int studentId;
	int schYear;
	int semester;
	int schType;
}
