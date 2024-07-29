package university.green.staff.repository.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.student.model.StudentDTO;
import university.green.util.DBUtil;

public class StudentRepositoryimpl implements StudentRepository{

	
	// 학생 추가하기
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

	// 학생 검색 - 학과 번호
	@Override
	public List<StudentDTO> getStudentByDeptId(int deptId) {
		List<StudentDTO> studentList=new ArrayList<>();
		StudentDTO student=null;
		final String SELECT_STUDENT_BY_ID=" SELECT * FROM student_tb where dept_id = ? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_STUDENT_BY_ID)){
			pstmt.setInt(1,deptId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				student=StudentDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).
						birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(deptId).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date")).build();
				studentList.add(student);
				System.out.println("deptid 조회 : "+student );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	// 학생 검색 - id
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
						birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date")).build();
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	// 학생 검색 - 모든 학생
	@Override
	public List<StudentDTO> getAllStudent(int pageSize, int offset) {
		List<StudentDTO> studentList=new ArrayList<>();
		String SELECT_ALL_STUDENT=" SELECT * FROM student_tb ORDER BY id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_STUDENT)){
			pstmt.setInt(1,pageSize);
			pstmt.setInt(2, offset);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				StudentDTO student=StudentDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
				.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email")).deptId(rs.getInt("dept_id"))
				.grade(rs.getInt("grade")).semester(rs.getInt("semester")).entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date")).build();
				studentList.add(student);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return studentList;
	}

	// 학생 수정
	@Override
	public void updateStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		
	}

	// 학생 삭제
	@Override
	public void deleteStudent(int id, int principalId) {
		// TODO Auto-generated method stub
		
	}

	// 학생 검색 - 과+id
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
						birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(deptId).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date")).build();
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	// 재학 중인 학생 검색
	@Override
	public List<StudentDTO> getTuiStudent() {
		List<StudentDTO> studentList=new ArrayList<>();
		final String SELECT_STUDENT_BY_STATUS=" select s.id as id, s.name as name, s.birth_date as birth_date, s.gender as gender, s.address as address, "
				+ " s.tel as tel, s.email as email, s.dept_id as dept_id, s.grade as grade, s.semester as semester, s.entrance_date as entrance_date, s.graduation_date as graduation_date "
				+ " from student_tb as s "
				+ " join stu_stat_tb as st "
				+ " on s.id=st.student_id "
				+ " where st.status= '재학' ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_STUDENT_BY_STATUS)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				studentList.add(StudentDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).
						birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}
}
