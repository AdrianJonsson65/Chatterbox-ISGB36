package controler;
import model.User_Login;

public class AuthController {
	public static User_Login ConfirmLogin(String username, String password) {
		for (User_Login UL : User_Login.users) {
			if (UL.getUsername().equals(username) && UL.getPassword().equals(password)) {
				return UL;
			}
			}
		return null;
	}
}
