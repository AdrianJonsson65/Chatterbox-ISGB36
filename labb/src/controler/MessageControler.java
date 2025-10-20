package controler;

import java.util.*;
import model.*;

public class MessageControler {
	private List<Message> messages = new ArrayList<>();
	
	public void createMessage(String text) {
		Message m = new Message(text);
		if (text != null) {
			messages.add(m);
			System.out.println("Message created!");
			
		}else {
			System.out.println("Message is null");
		}
		
	}
	
	public void deleteMessages(int index) {
		if (index >= 0 && index < messages.size()) {
			messages.remove(index);
			System.out.println("Message deleted");
		}else {
			System.out.println("Invalid index");
		}
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList(messages);
	}
	
	public String [] getAllOwnMessages(User_Login author){
		return author.getOwnMessages();
	}
}
