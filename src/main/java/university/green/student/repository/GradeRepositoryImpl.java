package university.green.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.student.model.EachGradeDTO;
import university.green.student.model.TotalGradeDTO;
import university.green.student.repository.interfaces.GradeRepository;
import university.green.util.DBUtil;

public class GradeRepositoryImpl implements GradeRepository{

	// 학생별로 과목 조회
	@Override
	public List<EachGradeDTO> getAllEachGrade(int id) {
		List<EachGradeDTO> gradelist=new ArrayList<>();
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

	// 학기별 각 과목 리스트 조회
	@Override
	public List<EachGradeDTO> getEachGradeBySemester(int id, int year, int semester) {
		List<EachGradeDTO> gradelist=new ArrayList<>();
		final String SELECT_ALL_EACHGRADE=" select st.student_id,s.sub_year,s.semester, st.subject_id, s.name, s.type, st.complete_grade, st.grade "
				+ " from subject_tb as s "
				+ " join stu_sub_tb as st "
				+ " on s.id = st. subject_id "
				+ " where st.student_id = ? and semester = ?  ORDER BY st.subject_id";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_EACHGRADE)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, semester);
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

	// 학기별 평균 점수
	@Override
	public TotalGradeDTO getTotalGrade(int id, int year, int semester) {
		TotalGradeDTO totalGrade=new TotalGradeDTO();
		final String GET_TOTAL_GRADE=" select s.sub_year, s.semester, sum(s.grades), sum(st.complete_grade),avg(st.complete_grade) "
				+ "from stu_sub_tb as st "
				+ "join subject_tb as s "
				+ "on st.subject_id=s.id where st.student_id= ? and s.sub_year= ? and s.semester= ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_TOTAL_GRADE)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				totalGrade=TotalGradeDTO.builder().year(rs.getInt("sub_year")).semester(rs.getInt("semester")).registerdGrade(rs.getInt("sum(s.grades)"))
						.getGrade(rs.getDouble("sum(st.complete_grade)")).averageGrade(rs.getDouble("avg(st.complete_grade)")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalGrade;
	}

	// 학기별 모든 리스트 가져오기
	@Override
	public List<TotalGradeDTO> getAllTotalGrade(int id, int year, int semester) {
		List<TotalGradeDTO> totalGrade=new ArrayList<>();
		final String GET_TOTAL_GRADE=" select s.sub_year, s.semester, sum(s.grades), sum(st.complete_grade),avg(st.complete_grade) "
				+ "from stu_sub_tb as st "
				+ "join subject_tb as s "
				+ "on st.subject_id=s.id where st.student_id= ? and s.sub_year= ? and s.semester= ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_TOTAL_GRADE)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				totalGrade.add(TotalGradeDTO.builder().year(rs.getInt("sub_year")).semester(rs.getInt("semester")).registerdGrade(rs.getInt("sum(s.grades)"))
						.getGrade(rs.getDouble("sum(st.complete_grade)")).averageGrade(rs.getDouble("avg(st.complete_grade)")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalGrade;
	}


}
