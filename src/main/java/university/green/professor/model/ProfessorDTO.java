package university.green.professor.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
<<<<<<< HEAD
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfessorDTO {

	private Integer id;
	private String name;
	private Date birthDate;
=======

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
>>>>>>> b0e7350265a04c19bedf044ab27f2db7e1711e15
	private String gender;
	private String address;
	private String tel;
	private String email;
<<<<<<< HEAD
	private Integer deptId;
	private Date hireDate;
=======
	private int dept_int;
	private Date hire_date;
>>>>>>> b0e7350265a04c19bedf044ab27f2db7e1711e15
}
