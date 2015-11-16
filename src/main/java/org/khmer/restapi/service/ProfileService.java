package org.khmer.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.khmer.restapi.database.DatabaseClass;
import org.khmer.restapi.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("ssan", new Profile(1L,"ssan","sarith","san"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String nickname) {
		return profiles.get(nickname);
	}
	
	public Profile addProfile(Profile person) {
		person.setId(profiles.size() + 1);
		profiles.put(person.getNickName(), person);
		return person;
	}
	
	public Profile updateProfile(Profile person) {
		if(person.getNickName()==null) {
			return null;
		}
		
		profiles.put(person.getNickName(), person);
		return person;
	}
	
	public Profile removeProfile(String nickname) {
		return profiles.remove(nickname);
	}
	
}
