package university.green.staff.repository.interfaces;

import java.util.List;

<<<<<<< HEAD

import university.green.staff.model.Staff_tb;
=======
import university.green.staff.model.StaffDTO;
>>>>>>> origin/kim


public interface StaffRepository {
	// 교직원 - 교직원 등록하기
<<<<<<< HEAD
	void addStaff(Staff_tb staffDTO);
	// 교직원 - 수정하기
	void updateStaff(Staff_tb staffDTO);
=======
	void addStaff(StaffDTO staff);
	// 교직원 - 수정하기
	void updateStaff(StaffDTO staff);
>>>>>>> origin/kim
	// 교직원 - 비밀번호 변경하기
	void updateStaffForPassword(String password,int principalId);
	// 교직원 - 전체 교직원 조회하기
	List<Staff_tb> getAllStaff();
	// 교직원 - ID로 교직원 조회하기
	List<Staff_tb> getStaffByID(int id);
	// 교직원 - ID와 이름으로 조회하기
	
}
