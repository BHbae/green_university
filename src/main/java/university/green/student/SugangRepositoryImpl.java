package university.green.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.student.model.SugangDTO;
import university.green.student.repository.SugangRepository;
import university.green.util.DBUtil;

public class SugangRepositoryImpl implements SugangRepository {
	private static final String SELECT_SUGANG = "select sub.id coll.name as college , dep.name as department, sub.id as departNum , sub.type as majorType, \r\n"
			+ "sub.name as subjectName, pro.name as professorName, sub.grades as grades, sub.sub_day as subjectDay, \r\n"
			+ "sub.start_time as subjectStart, sub.end_time as subjectEnd, sub. room_id as room, sub.num_of_student as currentStudent, sub.capacity as capacity\r\n"
			+ "from subject_tb as sub\r\n"
			+ "join professor_tb as pro\r\n"
			+ "on pro.id = sub.professor_id\r\n"
			+ "join department_tb as dep\r\n"
			+ "on dep.id = sub.dept_id\r\n"
			+ "join college_tb as coll\r\n"
			+ "on dep.college_id = coll.id\r\n"
			+ "where sub.type like %% and dep.name like %% and sub.name like %% ORDER BY id asc limit ? offset ? ";
	private static final String COUNT_ALL_BOARDS = " SELECT COUNT(*) as count FROM subject_tb ";
	@Override
	public List<SugangDTO> listBoard(int limit, int offset) {
		List<SugangDTO> boardsList = new ArrayList<>();
		
		 try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_SUGANG);
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				boardsList.add(SugangDTO.builder()
					.id(rs.getInt("id"))
					.college(rs.getString("college"))
					.department(rs.getString("department"))
					.majorType(rs.getString("majorType"))
					.departNum(rs.getInt("departNum"))
					.subjectName(rs.getString("subjectName"))
					.professorName(rs.getString("professorName"))
					.grades(rs.getInt("grades"))
					.subjectDay(rs.getString("subjectDay"))
					.subjectStart(rs.getInt("subjectStart"))
					.subjectEnd(rs.getInt("subjectEnd"))
					.room(rs.getString("room"))
					.capacity(rs.getInt("capacity"))
					.currentStudent(rs.getInt("currentStudent"))
					.build());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardsList;
		
	}
	@Override
	public int getTotalBoardCount() {
int count = 0;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL_BOARDS)){
				
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("로깅 totoalCount : " + count);
		return count;
	}

	
}
