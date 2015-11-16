package org.khmer.restapi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.khmer.restapi.database.DatabaseClass;
import org.khmer.restapi.model.Message;

public class MessageService {

	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1,"Hello world","sam san"));
		messages.put(2L, new Message(2,"hello jersey","Bob Smith"));
	}
	
	public List<Message> getMessageForYear(int year){
		List<Message> msgYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message msg : messages.values()) {
			cal.setTime(msg.getCreatedDate());
			if(cal.get(Calendar.YEAR)==year) {
				msgYear.add(msg);
			}
		}
		return msgYear;
	}
	
	// get pagination
	public List<Message> getMessagePagination(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		return list.subList(start, start+size);
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		if(msg.getId() <=  0) {
			return null;
		}
		
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
