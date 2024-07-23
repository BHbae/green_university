package university.green.staff.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 학사일정(직원?)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Schedule_tb {

	private int id;
	private int staffId;
	private Date startDay;
	private Date endDay;
	private String information;
	
	
}
