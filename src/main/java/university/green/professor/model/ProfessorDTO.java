package university.green.professor.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 교수 DTO

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorDTO {
	private int id;
	private String name;
	private Date birth_date;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private int dept_int;
	private Date hire_date;
}
