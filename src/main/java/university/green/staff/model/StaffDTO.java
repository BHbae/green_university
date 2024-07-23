package university.green.staff.model;




import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// author: 쏭
// 교직원 DTO
@Data
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
<<<<<<< HEAD
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
=======
public class StaffDTO {
	private int id;
	private String name;
	private Date birth_date;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Date hire_date;
>>>>>>> song

