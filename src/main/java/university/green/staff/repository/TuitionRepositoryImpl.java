package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import university.green.staff.repository.interfaces.TuitionRepository;
import university.green.student.model.TuitionDTO;
import university.green.util.DBUtil;

public class TuitionRepositoryImpl implements TuitionRepository{

	@Override
	public void addTuition(int studentId) {
		TuitionDTO tuition=new TuitionDTO();
		final String ADD_TUITION=" INSERT INTO tuition_tb (student_id,tui_year,semester,tui_amount,sch_type,sch_amount,status) "
				+ " values ( ? , ? , ? , ? , ? , ? , ? )";
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_TUITION)){
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		List<TuitionDTO> tuitionList=null;
		final String GET_ALL_TUITION=" select * from tuition_tb ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_ALL_TUITION)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				TuitionDTO tuition=TuitionDTO.builder().student_id(rs.getInt("student_id")).tui_year(rs.getInt("tui_year"))
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
	public TuitionDTO getTuitionById(TuitionDTO tuitionDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
