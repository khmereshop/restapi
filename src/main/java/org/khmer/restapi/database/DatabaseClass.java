package org.khmer.restapi.database;

import java.util.HashMap;
import java.util.Map;

import org.khmer.restapi.model.Message;
import org.khmer.restapi.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	
	
	
}
