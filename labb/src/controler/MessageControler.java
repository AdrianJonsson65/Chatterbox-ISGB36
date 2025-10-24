package controler;

import java.util.*;
import model.*;
import view.LoginView;

public class MessageControler {
	private Message [] messages;
	private Message mess;
	private LoginView loginview;
	private User_Login ul;
	public MessageControler() {
		mess = new Message();
		loginview = new LoginView();
		messages = new Message[0];
		
	}
	
	public void createMessage(String text, User_Login obj) {
		messages = mess.addMessage(text,obj);
		obj.addOwnMessage(text, obj);
		
	}
	
	public void deleteMessage(int mId, User_Login obj) {
		messages = mess.deleteMessage(mId, obj);
		obj.deleteOwnMessage(mId, obj);
	}
	

	public Message [] getAllOwnMessages(User_Login author){
		return author.getOwnMessages(author);
	}
	
	public void viewAllMessages() {
		Message[] messages = mess.getAllMessages();
		loginview.viewMessages(messages);
	}
	
	public void viewAllOwnMessages(User_Login obj) {
		Message [] mUser = obj.getOwnMessages(obj);
		loginview.viewMessages(mUser);
	}
}
