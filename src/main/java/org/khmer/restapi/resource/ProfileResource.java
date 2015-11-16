package org.khmer.restapi.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.khmer.restapi.model.Profile;
import org.khmer.restapi.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfile() {
		return profileService.getAllProfiles();
		
	}
	
	@GET
	@Path("/{nickname}")
	public Profile getAProfile(@PathParam("nickname") String nickname) {
		
		return profileService.getProfile(nickname);
	}
	
	@POST
	public Profile postAProfile(Profile person) {
		
		return profileService.addProfile(person);
		
	}
	
	@PUT
	@Path("/{nickname}")
	public Profile updateAProfile(@PathParam("nickname") String nickname,Profile person) {
		person.setNickName(nickname);
		return profileService.updateProfile(person);
		
	}
	
	@DELETE
	@Path("/{nickname}")
	public void deleteAProfile(@PathParam("nickname") String nickname) {
		profileService.removeProfile(nickname);
		
	}
	
}
