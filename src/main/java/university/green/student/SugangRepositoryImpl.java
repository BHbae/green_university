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
	private static final String SELECT_SUGANG = "select sub.id, coll.name as college, dep.name as department, sub.id as departNum, sub.type as majorType, "
			+ " sub.name as subjectName, pro.name as professorName, sub.grades as grades, sub.sub_day as subjectDay, "
			+ " sub.start_time as subjectStart, sub.end_time as subjectEnd, sub. room_id as room, sub.num_of_student as currentStudent, sub.capacity as capacity "
			+ " from subject_tb as sub "
			+ " join professor_tb as pro "
			+ " on pro.id = sub.professor_id "
			+ " join department_tb as dep "
			+ " on dep.id = sub.dept_id "
			+ " join college_tb as coll "
			+ " on dep.college_id = coll.id "
			+ " ORDER BY id asc limit ? offset ?";
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
	
	
	
	@Override
	public List<SugangDTO> preApply(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SugangDTO> SugangApply(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SugangDTO> ApplyInfo(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
