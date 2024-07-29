package university.green.staff.repository.interfaces;

import university.green.LoginDto;

public interface staffpassRepository {
	
	int setPassword(int principalid, int setPassword);
	LoginDto stafflogin(int id,int Password);
	
}
//체크
