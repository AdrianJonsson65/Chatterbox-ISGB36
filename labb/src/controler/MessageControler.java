package controler;

import java.sql.SQLException;
import java.util.*;
import model.*;
import view.LoginView;

public class MessageControler {
	private ArrayList<Message> messages;
	private Message mess;
	private LoginView loginview;
	
	public MessageControler() {
		mess = new Message();
		loginview = new LoginView();
		messages = new ArrayList<>();
		
	}
	
	public void createMessage(String text, User_Login obj) throws SQLException {
		messages = mess.addMessage(text,obj);
		//obj.addOwnMessage(text, obj);
		
	}
	
	public void deleteMessage(String mId, User_Login obj) throws SQLException {
		messages = mess.deleteMessage(mId, obj);
		//obj.deleteOwnMessage(mId, obj);
	}
	

	public ArrayList<Message> getAllOwnMessages(User_Login author) throws SQLException{
		DAO dao = new DAO();
		ArrayList<Message> ownMessages = dao.getAllMessagesByUser(author);
		return ownMessages;
	}
	
	public void viewAllMessages() throws SQLException {
		ArrayList<Message> messages = mess.getAllMessages();
		loginview.viewMessages(messages);
	}
	
	public void viewAllOwnMessages(User_Login obj) throws SQLException {
		DAO dao = new DAO();
		ArrayList<Message> ownMessages = dao.getAllMessagesByUser(obj);
		//Message [] mUser = obj.getOwnMessages(obj);
		loginview.viewMessages(ownMessages);
	}
}
