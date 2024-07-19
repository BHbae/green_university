package university.green.student;

import java.sql.Connection;
import java.sql.PreparedStatement;

import university.green.student.model.SugangDTO;
import university.green.student.repository.SugangRepository;
import university.green.util.DBUtil;

public class SugangRepositoryImpl implements SugangRepository {
	private static final String SELECT_SUGANG = "select coll.name as college , dep.name as department, sub.id as departNum , sub.type as majorType, \r\n"
			+ "sub.name as subjectName, pro.name as professorName, sub.grades as grades, sub.sub_day as subjectDay, \r\n"
			+ "sub.start_time as subjectStart, sub.end_time as subjectEnd, sub. room_id as room, sub.num_of_student as currentStudent, sub.capacity as capacity\r\n"
			+ "from subject_tb as sub\r\n"
			+ "join professor_tb as pro\r\n"
			+ "on pro.id = sub.professor_id\r\n"
			+ "join department_tb as dep\r\n"
			+ "on dep.id = sub.dept_id\r\n"
			+ "join college_tb as coll\r\n"
			+ "on dep.college_id = coll.id\r\n"
			+ "where sub.type like %?% and dep.name like %?% and sub.name like %?%; ";
	@Override
	public void SearchInfo(SugangDTO sugangDTO) {
		 try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_SUGANG);
			pstmt.setString(1, sugangDTO.getCollege());
			pstmt.setString(2, sugangDTO.getDepartment());
			pstmt.setString(3, sugangDTO.getSubjectName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
