package university.green.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.professor.model.lectureDTO;
import university.green.professor.model.subjectDTO;
import university.green.professor.repositoryinterfaces.lectureList;
import university.green.util.DBUtil;

public class lectureListImpl implements lectureList {
	private final String ALL_LIST_LECTURE = " select sub.id, coll.name as college , dep.name as department, sub.id as departNum , sub.type as majorType, "
			+ " sub.name as subjectName, pro.name as professorName, sub.grades as grades, sub.sub_day as subjectDay, "
			+ " sub.start_time as subjectStart, sub.end_time as subjectEnd, sub. room_id as room, sub.num_of_student as currentStudent, sub.capacity as capacity "
			+ " from subject_tb as sub "
			+ " join professor_tb as pro "
			+ " on pro.id = sub.professor_id "
			+ " join department_tb as dep "
			+ " on dep.id = sub.dept_id "
			+ " join college_tb as coll "
			+ " on dep.college_id = coll.id "
			+ " ORDER BY id asc "
			+ "limit ? offset ? ";
	
	private final String SELECT_MY_LECTURE  =  "SELECT * FROM subject_tb where professor_id = ? " ;
	private final String ALL_TOTAL_PAGE = " select count(*) as count from subject_tb ";
	
	@Override
	public List<lectureDTO> lectureAllList(int limit, int offset) {
		List<lectureDTO> list = new ArrayList<>(); 
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(ALL_LIST_LECTURE)){
				pstmt.setInt(1, limit);
				pstmt.setInt(2, offset);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					lectureDTO dto = lectureDTO.builder()
							.id(rs.getInt("id"))
							.college(rs.getString("college"))
							.department(rs.getString("department"))
							.departNum(rs.getInt("departNum"))
							.majorType(rs.getString("majorType"))
							.subjectName(rs.getString("subjectName"))
							.professorName(rs.getString("professorName"))
							.grades(rs.getInt("grades"))
							.subjectDay(rs.getString("subjectDay"))
							.subjectStart(rs.getInt("subjectStart"))
							.subjectEnd(rs.getInt("subjectEnd"))
							.room(rs.getString("room"))
							.currentStudent(rs.getInt("currentStudent"))
							.capacity(rs.getInt("capacity"))
							.build();
					list.add(dto);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void lectureSelectList() {
		
		
	}

	@Override
	public List<subjectDTO> myLecture(int professorId) {
		List<subjectDTO> list = new ArrayList<>(); 
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_MY_LECTURE)){
			pstmt.setInt(1, professorId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				subjectDTO dto = subjectDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.professor(rs.getInt("professor_id"))
						.roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id"))
						.type(rs.getString("type"))
						.subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester"))
						.subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time"))
						.endTime(rs.getInt("end_time"))
						.greades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("num_of_student"))
						.build();
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void myLectureScore() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getTotalLectyreCount() {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(ALL_TOTAL_PAGE)){
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
