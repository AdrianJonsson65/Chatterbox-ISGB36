package controler;
import java.sql.SQLException;

import model.User_Login;

public class AuthController {
	private User_Login ul;
	public AuthController() {
		ul = new User_Login();
	}
	
	public User_Login ConfirmLogin() throws SQLException {
		ul = ul.login();
		return ul;
	}
}
