package university.green.staff.repository;

import university.green.staff.model.StaffDTO;

public interface StaffRepository {
	// 교직원 - 교직원 등록하기
	void addStaff(StaffDTO staffDTO);
	// 교직원 - 수정하기
	void updateStaff(StaffDTO staffDTO);
	// 교직원 - 비밀번호 변경하기
	void updateStaffForPassword(String password,int principalId);
}
