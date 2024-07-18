package university.green.staff.model;

<<<<<<< HEAD
public class StaffDTO {

=======
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
public class StaffDTO {

	public class ProfessorDTO {
		private int id;
		private String name;
		private Date birth_date;
		private String gender;
		private String address;
		private String tel;
		private String email;
		private Date hire_date;
	}

>>>>>>> b0e7350265a04c19bedf044ab27f2db7e1711e15
}
