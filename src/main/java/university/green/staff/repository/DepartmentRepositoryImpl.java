package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.CollegeDTO;
import university.green.staff.model.DepartmentDTO;
import university.green.staff.repository.interfaces.DepartmentRepository;
import university.green.util.DBUtil;

// 등록 - 학과
public class DepartmentRepositoryImpl implements DepartmentRepository {

	private static final String SELECT_ALL_DEPARTMENT = " SELECT * FROM department_tb ";
	private static final String INSERT_ADD_DEPARTMENT = " INSERT INTO department_tb(name, college_id) VALUES (?, ?) ";
	private static final String DELETE_DEPARTMENT = " DELETE FROM department_tb WHERE id = ? ";
	private static final String UPDATE_DEPARTMENT = " UPDATE department_tb set name = ? WHERE id = ? ";
	private static final String ALL_TOTAL_PAGE = " SELECT count(*) as count FROM department_tb ";
	
	private static final String CATEGORY_SELECT_ALL = " select * from college_tb ";
	
	@Override
	public List<DepartmentDTO> departmentList() {
		List<DepartmentDTO> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_DEPARTMENT);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto = DepartmentDTO.builder()
								   .id(rs.getInt("id"))
								   .name(rs.getString("name"))
								   .collegeId(rs.getInt("college_id")) // 똑같이
								   .build();
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 카테고리 
	@Override
	public List<CollegeDTO> CategoryList() {
		List<CollegeDTO> category = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(CATEGORY_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CollegeDTO dto = new CollegeDTO();
				dto = CollegeDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				category.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return category;
	}
	

	@Override 
	public int addDepartment(DepartmentDTO dto) {
		
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ADD_DEPARTMENT)){
				pstmt.setString(1,dto.getName());
				pstmt.setInt(2, dto.getCollegeId());
				rowCount = pstmt.executeUpdate();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
		
	}

	@Override
	public int updateDepartment(DepartmentDTO dto) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_DEPARTMENT)){
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getCollegeId());
				rowCount = pstmt.executeUpdate();
				
				conn.commit();
				
				
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int deleteDepartment(int id) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_DEPARTMENT)){
				pstmt.setInt(1,id);
				rowCount = pstmt.executeUpdate();
				
				conn.commit();
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int getCounte() {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(ALL_TOTAL_PAGE)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}


