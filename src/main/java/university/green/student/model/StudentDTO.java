package university.green.student.model;

<<<<<<< HEAD
public class StudentDTO {

=======
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 학생 정보 DTO

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentDTO {
	private int id; // 학생 ID
	private String name; // 학생 이름
	private Date birth_date; // 생일
	private String gender; // 성별
	private String address; // 주소
	private String tel; // 전화번호
	private String email; // 이메일
	private int dept_id; // 학과 ID
	private int grade; // 학년
	private int semester; // 학기
	private Date entrance_date; // 입학일
	private Date graduation_date; //졸업일
>>>>>>> b0e7350265a04c19bedf044ab27f2db7e1711e15
}
