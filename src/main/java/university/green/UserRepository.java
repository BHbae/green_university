package university.green;

public interface UserRepository {
	
	LoginDto userId(int id, String password);
	LoginDto user_role(LoginDto role);
	
}
