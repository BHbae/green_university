package university.green.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import university.green.student.model.StuSchDTO;
import university.green.student.repository.interfaces.StuSchRepository;
import university.green.util.DBUtil;

public class StuSchRepositoryImpl implements StuSchRepository{

	@Override
	public StuSchDTO getStuSchById(int id,int semester) {
		StuSchDTO stuSch=new StuSchDTO();
		final String GET_STUSCH_BY_ID=" select * from sct_sch_tb where id=? , semester = ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_STUSCH_BY_ID)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, semester);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				stuSch=StuSchDTO.builder().studentId(rs.getInt("student_id")).schYear(rs.getInt("sch_year"))
						.semester(rs.getInt("semester")).schType(rs.getInt("sch_type")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stuSch;
	}

	
	// stu_sch_tb 추가하기
	@Override
	public int addStuSchById(int studentId) {
		final String ADD_STU_SCH=" INSERT INTO stu_sch_tb (student_id,sch_year,semester, sch_type)"
				+ " values ( ?, ?, ?, ?) ";
		int a=0;
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_STU_SCH)){
				pstmt.setInt(1, studentId);
				pstmt.setInt(2,2024);
				pstmt.setInt(3, 2);
				pstmt.setInt(4,2);
				a=pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}

}
