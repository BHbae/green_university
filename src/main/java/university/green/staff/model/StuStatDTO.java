package university.green.staff.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

// 학생 학적 상태 
public class StuStatDTO {
	int id;
	int studentId;
	String status;
	Date fromDate;
	Date toDate;
	int breakAppId;
}
