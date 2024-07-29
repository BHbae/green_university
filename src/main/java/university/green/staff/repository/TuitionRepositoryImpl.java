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
		final String ADD_TUITION="  select s.id as student_id, s.entrance_date as tui_year, s.semester as semester,  ctt.amount as tui_amount, stc.sch_type as sch_type, sch.max_amount as sch_amount, stt.status as status "
				+ " from student_tb as s "
				+ " join stu_sch_tb as stc "
				+ " on s.id=stc.student_id "
				+ " join scholarship_tb as sch "
				+ " on stc.sch_type=sch.type "
				+ " join department_tb as d "
				+ " on d.id=s.dept_id "
				+ " join college_tb as c "
				+ " on c.id=d.college_id "
				+ " join stu_stat_tb as stt "
				+ " on s.id=stt.student_id "
				+ " join coll_tuit_tb as ctt "
				+ " on c.id=ctt.college_id where s.id =? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(ADD_TUITION)){
			pstmt.setInt(1, studentId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				tuition=TuitionDTO.builder().student_id(rs.getInt("student_id")).tui_year(2024).semester(rs.getInt("semester")).tui_amount(rs.getInt("tui_amount"))
						.sch_type(rs.getInt("sch_type")).sch_amount(rs.getInt("sch_amount")).status(0).build();
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
				pstmt.setInt(4, tuition.getSch_amount());
				pstmt.setInt(5, tuition.getSch_type());
				pstmt.setInt(6, tuition.getSch_amount());
				pstmt.setInt(7, tuition.getStatus());
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				System.out.println("실패 ㅜㅜ흥");
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
