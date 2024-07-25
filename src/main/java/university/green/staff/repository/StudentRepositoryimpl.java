package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.repository.interfaces.StudentRepository;
import university.green.student.model.StudentDTO;
import university.green.util.DBUtil;

public class StudentRepositoryimpl implements StudentRepository{

	@Override
	public void addStudent(StudentDTO studentDTO) {
		final String ADD_STUDENT=" INSERT INTO student_tb"
				+ "(name, birth_date, gender, address, tel, email, dept_id, grade, semester, entrance_date, graduation_date) "
				+ "values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
		StudentDTO student=studentDTO;
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_STUDENT)){
				pstmt.setString(1,student.getName());
				pstmt.setDate(2, student.getBirthDate());
				pstmt.setString(3, student.getGender());
				pstmt.setString(4, student.getAddress());
				pstmt.setString(5, student.getTel());
				pstmt.setString(6, student.getEmail());
				pstmt.setInt(7, student.getDeptId());
				pstmt.setInt(8, student.getGrade());
				pstmt.setInt(9, student.getSemester());
				pstmt.setDate(10, student.getEntranceDate());
				pstmt.setDate(11, student.getGraduationDate());
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StudentDTO> getStudentByDeptId(int deptId) {
		List<StudentDTO> studentList=new ArrayList<>();
		StudentDTO student=null;
		final String SELECT_STUDENT_BY_ID=" SELECT * FROM student_tb where dept_id = ? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_STUDENT_BY_ID)){
			pstmt.setInt(1,deptId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				student=StudentDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).
						birthDate(rs.getDate("birthDate")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(deptId).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entranceDate")).graduationDate(rs.getDate("graduationDate")).build();
				return studentList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public StudentDTO getStudentById(int id) {
		StudentDTO student=null;
		final String SELECT_STUDENT_BY_ID=" SELECT * FROM student_tb where id = ? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_STUDENT_BY_ID)){
			pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				student=StudentDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).
						birthDate(rs.getDate("birthDate")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("deptId")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entranceDate")).graduationDate(rs.getDate("graduationDate")).build();
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<StudentDTO> getAllStudent() {
		List<StudentDTO> studentList=new ArrayList<>();
		String SELECT_ALL_STUDENT=" SELECT * FROM student_tb ORDER BY id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_STUDENT)){
			pstmt.setInt(1,20);
			pstmt.setInt(2, 5);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				StudentDTO student=StudentDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
				.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email")).deptId(rs.getInt("dept_id"))
				.grade(rs.getInt("grade")).semester(rs.getInt("semester")).entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date")).build();
				studentList.add(student);
				System.out.println(student);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public void updateStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int id, int principalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentDTO getStudentByDeptidAndId(int deptId, int id) {
		StudentDTO student=null;
		final String SELECT_STUDENT_BY_DEPTID_AND_ID=" SELECT * FROM student_tb WHERE dept_id= ? and id= ? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_STUDENT_BY_DEPTID_AND_ID)){
				pstmt.setInt(1,deptId);
				pstmt.setInt(2, id);
				ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				student=StudentDTO.builder().id(id).name(rs.getString("name")).
						birthDate(rs.getDate("birthDate")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(deptId).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entranceDate")).graduationDate(rs.getDate("graduationDate")).build();
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<StudentDTO> getTuiStudent() {
		List<StudentDTO> studentList=null;
		final String SELECT_STUDENT_BY_SCH_TYPE="  ";
		return null;
	}
}
