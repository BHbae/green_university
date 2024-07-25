package university.green.professor.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 교수 DTO

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ProfessorDTO {
	private int id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private int deptId;
	private Date hireDate;
}

//찐