package university.green.staff.repository;

<<<<<<< HEAD
public interface StaffRepository {

=======
import university.green.staff.model.StaffDTO;

public interface StaffRepository {
	// 교직원 - 교직원 등록하기
	void addStaff(StaffDTO staffDTO);
	// 교직원 - 수정하기
	void updateStaff(StaffDTO staffDTO);
	// 교직원 - 비밀번호 변경하기
	void updateStaffForPassword(String password,int principalId);
>>>>>>> b0e7350265a04c19bedf044ab27f2db7e1711e15
}
