package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.repository.interfaces.TuitionRepository;
import university.green.student.model.TuitionDTO;
import university.green.util.DBUtil;

public class TuitionRepositoryImpl implements TuitionRepository{

	
	
	// TuitionDTO 만들기
	@Override
	public TuitionDTO addTuition(int studentId) {
		TuitionDTO tuition=new TuitionDTO();
		final String ADD_TUITION=" select s.id, s.grade,s.semester,ct.amount,sch.sch_type,scho.max_amount,stt.status "
				+ "from student_tb as s "
				+ "join department_tb as d "
				+ "on s.dept_id=d.id "
				+ "join coll_tuit_tb as ct "
				+ "on d.college_id = ct.college_id "
				+ "join stu_sch_tb as sch "
				+ "on s.id=sch.student_id "
				+ "join scholarship_tb as scho "
				+ "on sch.sch_type=scho.type "
				+ "join stu_stat_tb as stt "
				+ "on s.id=stt.student_id where s.id= ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(ADD_TUITION)){
			pstmt.setInt(1, studentId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				tuition=TuitionDTO.builder().student_id(rs.getInt("id")).tui_year(rs.getInt("grade")).semester(rs.getInt("semester")).tui_amount(rs.getInt("amount"))
						.sch_type(rs.getInt("sch_type")).sch_amount(rs.getInt("max_amount")).status(rs.getInt("status")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tuition;
	}

	@Override
	public void updateTuition(TuitionDTO tuitionDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTuition(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TuitionDTO> getAllTuition() {
		List<TuitionDTO> tuitionList=new ArrayList<>();
		final String GET_ALL_TUITION=" select * from tuition_tb ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_ALL_TUITION)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				TuitionDTO tuition=TuitionDTO.builder().student_id(rs.getInt("student_id")).tui_year(rs.getInt("tui_year")).semester(rs.getInt("semestet"))
						.tui_amount(rs.getInt("tui_amount")).sch_type(rs.getInt("sch_type")).sch_amount(rs.getInt("sch_amount"))
						.status(rs.getInt("status")).build();
				tuitionList.add(tuition);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tuitionList;
	}

	@Override
	public TuitionDTO getTuitionById(int id,int year, int semester) {
		TuitionDTO tuition=new TuitionDTO();
		final String GET_TUITION_BY_ID=" select * from tuition_tb where student_id= ? tui_year=? and semester =? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_TUITION_BY_ID)){
			pstmt.setInt(1,id);
			pstmt.setInt(2,year);
			pstmt.setInt(3,semester);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				tuition=TuitionDTO.builder().student_id(rs.getInt("student_id")).tui_year(rs.getInt("tui_year")).semester(rs.getInt("semestet"))
						.tui_amount(rs.getInt("tui_amount")).sch_type(rs.getInt("sch_type")).sch_amount(rs.getInt("sch_amount"))
						.status(rs.getInt("status")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tuition;
	}

	@Override
	public void addDbTuition(TuitionDTO tuition) {
		final String ADD_TUITION=" INSERT INTO tuition_tb (student_id,tui_year,semester,tui_amount,sch_type,sch_amount,status)"
				+ " values (?, ?, ?, ?, ?, ?, ?) ";
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_TUITION)){
				pstmt.setInt(1, tuition.getStudent_id());
				pstmt.setInt(2, tuition.getTui_year());
				pstmt.setInt(3, tuition.getSemester());
				pstmt.setInt(4, tuition.getSch_type());
				pstmt.setInt(5, tuition.getSch_amount());
				pstmt.setInt(6, tuition.getStatus());
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
	public TuitionDTO getTuitionById(int id) {
		TuitionDTO tuition=new TuitionDTO();
		final String GET_TUITION_BY_ID=" select * from tuition_tb where student_id= ? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_TUITION_BY_ID)){
			pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				tuition=TuitionDTO.builder().student_id(rs.getInt("student_id")).tui_year(rs.getInt("tui_year")).semester(rs.getInt("semestet"))
						.tui_amount(rs.getInt("tui_amount")).sch_type(rs.getInt("sch_type")).sch_amount(rs.getInt("sch_amount"))
						.status(rs.getInt("status")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tuition;
	}

}
