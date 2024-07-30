package university.green.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.student.model.PreSugangListDTO;
import university.green.student.model.SugangDTO;
import university.green.student.model.SugangSubDTO;
import university.green.student.repository.interfaces.SugangRepository;
import university.green.util.DBUtil;

public class SugangRepositoryImpl implements SugangRepository {
	// 강의 전체
	private static final String ALL_SUGANG = "select sub.id, coll.name as college, dep.name as department, sub.id as departNum, sub.type as majorType, "
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
	// 강의 목록 갯수
	private static final String COUNT_ALL_BOARDS = " SELECT COUNT(*) as count FROM subject_tb ";
	
	// 강의 개별 조회
	private static final String SEARCH_SUGANG = " select sub.id, coll.name as college , dep.name as department, sub.id as departNum , sub.type as majorType, "
			+ "sub.name as subjectName, pro.name as professorName, sub.grades as grades, sub.sub_day as subjectDay, "
			+ "sub.start_time as subjectStart, sub.end_time as subjectEnd, sub. room_id as room, sub.num_of_student as currentStudent, sub.capacity as capacity "
			+ "from subject_tb as sub "
			+ "join professor_tb as pro "
			+ "on pro.id = sub.professor_id "
			+ "join department_tb as dep "
			+ "on dep.id = sub.dept_id "
			+ "join college_tb as coll "
			+ "on dep.college_id = coll.id "
			+ "where sub.type like ? and dep.name like ? and sub.name like ? "
			+ "ORDER BY id asc "
			+ "limit ? offset ?";
	
	// 신청시 현재정원 plus
	private static final String STUDENT_PLUS = " UPDATE subject_tb "
			+ " SET num_of_student = num_of_student + 1 "
			+ " WHERE id = ? ";
	
	// 신청시 현재정원 minus
	private static final String STUDENT_MINUS = " UPDATE subject_tb "
			+ " SET num_of_student = num_of_student - 1 "
			+ " WHERE id = ? ";
	// 예비수강 리스트 체크
	private static final String CHECK_PRESUBJECT = "SELECT * FROM pre_stu_sub_tb" ;
	// 예비수강 수락 
	private static final String ADD_PRESUBJECT = "INSERT INTO pre_stu_sub_tb (student_id, subject_id) values(?, ?) " ;
	// 예비 수강 취소 
	private static final String SUBTRACT_PRESUBJECT = "DELETE FROM pre_stu_sub_tb WHERE student_id = ? and subject_id = ?" ;
	
	// 학생 ID로 예비 수강 조회
	private static final String CHECK_BY_STUDENT_ID = "SELECT * FROM pre_stu_sub_tb WHERE student_id = ?" ;
	
	@Override
	public List<SugangDTO> listBoard(int limit, int offset) {
		List<SugangDTO> boardsList = new ArrayList<>();
		
		 try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(ALL_SUGANG);
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
	public List<SugangDTO> searchBoard(String majorType, String department, String subjectName, int limit, int offset) {
		List<SugangDTO> searchList = new ArrayList<>();
		
		 try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SEARCH_SUGANG);
			pstmt.setString(1, "%" + majorType + "%");
	        pstmt.setString(2, "%" + department + "%");
	        pstmt.setString(3, "%" + subjectName + "%");
			pstmt.setInt(4, limit);
			pstmt.setInt(5, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				searchList.add(SugangDTO.builder()
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
		return searchList;
	}
	
	@Override
	public List<SugangDTO> preApply(int limit, int offset) {
		List<SugangDTO> preBoardList = new ArrayList<>();
		
		 try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(ALL_SUGANG);
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				preBoardList.add(SugangDTO.builder()
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
		return preBoardList;
	}
	
	
	@Override
	public List<SugangDTO> preSearchBoard(String majorType, String department, String subjectName, int limit, int offset) {
		List<SugangDTO> preSearchList = new ArrayList<>();
		
		 try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SEARCH_SUGANG);
			pstmt.setString(1, "%" + majorType + "%");
	        pstmt.setString(2, "%" + department + "%");
	        pstmt.setString(3, "%" + subjectName + "%");
			pstmt.setInt(4, limit);
			pstmt.setInt(5, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				preSearchList.add(SugangDTO.builder()
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
		return preSearchList;
	}
	
	@Override
	public void StudentPlus(int id) {
		try (Connection conn = DBUtil.getConnection()) {
	        PreparedStatement pstmt = conn.prepareStatement(STUDENT_PLUS);
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public void StudentMinus(int id) {
		try (Connection conn = DBUtil.getConnection()) {
	        PreparedStatement pstmt = conn.prepareStatement(STUDENT_MINUS);
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public int AddPreSugang(int studentId, int subjectId) {
		// List<PreSugangListDTO> AddPreSugangList = new ArrayList<>();
		int flag=0;
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(ADD_PRESUBJECT);
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subjectId);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public void SubtractPreSugang(int studentId, int subjectId) {
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SUBTRACT_PRESUBJECT);
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subjectId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
	}
	
	@Override
	public void CheckPreSugang(int studentId, int subjectId) {
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(CHECK_PRESUBJECT);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}
	
	@Override
	public List<PreSugangListDTO> CheckById(int studentId) { 
		List<PreSugangListDTO> CheckById = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(CHECK_BY_STUDENT_ID);
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				CheckById.add(PreSugangListDTO.builder().studentId(rs.getInt("student_id")).subjectId(rs.getInt("subject_id")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CheckById;
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
