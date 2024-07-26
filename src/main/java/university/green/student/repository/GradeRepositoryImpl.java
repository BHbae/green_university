package university.green.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import university.green.student.model.EachGradeDTO;
import university.green.student.model.TotalGradeDTO;
import university.green.student.repository.interfaces.GradeRepository;
import university.green.util.DBUtil;

public class GradeRepositoryImpl implements GradeRepository{

	// 학기별 
	@Override
	public List<EachGradeDTO> getAllEachGrade(int id) {
		List<EachGradeDTO> gradelist=null;
		final String SELECT_ALL_EACHGRADE=" select st.student_id,s.sub_year,s.semester, st.subject_id, s.name, s.type, st.complete_grade, st.grade "
				+ " from subject_tb as s "
				+ " join stu_sub_tb as st "
				+ " on s.id = st. subject_id "
				+ " where st.student_id = ?  ORDER BY subject_id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_EACHGRADE)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, 10);
			pstmt.setInt(3, 5);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EachGradeDTO eachGrade=EachGradeDTO.builder().studentId(rs.getInt("student_id")).subYear(rs.getInt("sub_year")).semester(rs.getInt("semester"))
						.subjectId(rs.getInt("subject_id")).name(rs.getString("name")).type(rs.getString("type")).grades(rs.getInt("complete_grade"))
						.grade(rs.getString("grade")).build();
				gradelist.add(eachGrade);
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gradelist;
	}

	@Override
	public List<EachGradeDTO> getEachGradeBySemester(int id, int year, int semester) {
		List<EachGradeDTO> gradelist=null;
		final String SELECT_ALL_EACHGRADE=" select st.student_id,s.sub_year,s.semester, st.subject_id, s.name, s.type, st.complete_grade, st.grade "
				+ " from subject_tb as s "
				+ " join stu_sub_tb as st "
				+ " on s.id = st. subject_id "
				+ " where st.student_id = ?, semester = ?  ORDER BY subject_id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_EACHGRADE)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, 10);
			pstmt.setInt(4, 5);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EachGradeDTO eachGrade=EachGradeDTO.builder().studentId(rs.getInt("student_id")).subYear(rs.getInt("sub_year")).semester(rs.getInt("semester"))
						.subjectId(rs.getInt("subject_id")).name(rs.getString("name")).type(rs.getString("type")).grades(rs.getInt("complete_grade"))
						.grade(rs.getString("grade")).build();
				gradelist.add(eachGrade);
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gradelist;
	}

	@Override
	public TotalGradeDTO getTotalGrade(int id, int year, int semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TotalGradeDTO> getAllTotalGrade(int id, int year, int semester) {
		// TODO Auto-generated method stub
		return null;
	}


}
