package university.green.staff.repository;

import university.green.staff.model.Schedule;

// 학사일정DTO
public interface ScheduleRepository {

	// 등록
	int addSchedule(Schedule schedule);
}