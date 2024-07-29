package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.RoomDTO;

public interface RoomRepositroy {

	// 등록 - 단대별 등록금
	
	// 전체 리스트
	List<RoomDTO> roomList();
	
	// 등록
	int addRoom(RoomDTO dto);
	
	
	// 삭제
	int deleteRoom(String id);
	
	
}
