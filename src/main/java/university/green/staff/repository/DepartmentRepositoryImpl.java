package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.DepartmentDTO;
import university.green.staff.repository.interfaces.DepartmentRepository;
import university.green.util.DBUtil;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	private static final String SELECT_ALL_DEPARTMENT = " SELECT * FROM department_tb ";
	private static final String INSERT_ADD_DEPARTMENT = " INSERT INTO department_tb(name, college_id) VALUES (?, ?) ";
	private static final String DELETE_DEPARTMENT = " DELETE FROM department_tb WHERE id = ? ";
	private static final String UPDATE_DEPARTMENT = " UPDATE department_tb set name = ? WHERE name = ?; ";
	private static final String ALL_TOTAL_PAGE = " SELECT count(*) as count FROM department_tb ";
	@Override
	public List<DepartmentDTO> departmentList() {
		List<DepartmentDTO> list = new ArrayList<>();
		
		return list;
	}

	@Override
	public DepartmentDTO addDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDepartment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDepartment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCounte() {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(ALL_TOTAL_PAGE)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("countS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}

