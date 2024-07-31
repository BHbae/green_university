package university.green.staff.repository.interfaces;

import university.green.staff.model.SubPeriodDTO;

public interface SubPeriodRepository {
	
	// 수강신청 기간 조회
	SubPeriodDTO getSubPeriod(int year,int semester);
	
	// 수강신청 시작
	void startSubPeriod(int year, int semester);
	
	// 수강신청 종료
	void stopSubPeriod(int year, int semester);

	// 수강신청 추가
	int addSubPeriod(int year,int semester);
}
