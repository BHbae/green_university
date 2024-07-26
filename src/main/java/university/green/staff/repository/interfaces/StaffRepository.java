package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.StaffDTO;

public interface StaffRepository {
	// 교직원 - 교직원 등록하기
	void addStaff(StaffDTO staff);
	// 교직원 - 수정하기
	void updateStaff(StaffDTO staff);
	// 교직원 - 비밀번호 변경하기
	void updateStaffForPassword(String password,int principalId);
	// 교직원 - 전체 교직원 조회하기
	List<StaffDTO> getAllStaff();
	// 교직원 - ID로 교직원 조회하기
	List<StaffDTO> getStaffByID(int id);
	// 교직원 - ID와 이름으로 조회하기
	StaffDTO getStaffByIdAndDeptId(int id,int deptId);
}
