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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.khmer.restapi.model.Message;
import org.khmer.restapi.service.MessageService;


@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService msgService = new MessageService();
	
	@GET
	public List<Message> getMessage(@QueryParam("year") int year, @QueryParam("start") int start, 
			@QueryParam("size") int size) {
		if(year > 0) {
			return msgService.getMessageForYear(year);
		}
		
		if(start >= 0 && size > 0) {
			return msgService.getMessagePagination(start, size);
		}
		
		return msgService.getAllMessages();
		
	}
	
	@GET
	@Path("{messageId}")
	public Message getAMessage(@PathParam("messageId") long messageId) {
		
		return msgService.getMessage(messageId);
	}
	
	@POST
	public Message postAMessage(Message msg) {
		
		return msgService.addMessage(msg);
		
	}
	

	@PUT
	@Path("{messageId}")
	public Message updateAMessage(@PathParam("messageId") long id,Message msg) {
		msg.setId(id);
		return msgService.updateMessage(msg);
		
	}
	
	@DELETE
	@Path("{messageId}")
	public void deleteAMessage(@PathParam("messageId") long id) {
		msgService.removeMessage(id);
		
	}
	
}
