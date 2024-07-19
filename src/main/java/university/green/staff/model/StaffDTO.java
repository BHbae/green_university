package university.green.staff.model;




import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// author: 쏭
// 교직원 DTO

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

	public class StaffDTO {
		private int id;
		private String name;
		private Date birth_date;
		private String gender;
		private String address;
		private String tel;
		private String email;
		private Date hire_date;
	}

