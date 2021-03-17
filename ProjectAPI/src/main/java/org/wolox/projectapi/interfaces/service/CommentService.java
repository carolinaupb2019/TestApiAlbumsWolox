package org.wolox.projectapi.interfaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wolox.projectapi.domain.Comment;
import org.wolox.projectapi.interfaces.client.ApiExternalClient;
import org.wolox.projectapi.interfaces.client.IComment;

@Service
public class CommentService implements IComment{
	
	@Autowired
	ApiExternalClient api;
	
    public List<Comment> getCommentsByName (String name) {
		
    	List<Comment> listComments= api.getComments().getBody();
    	listComments.removeIf(c -> !c.getName().equals(name));
    	
		return listComments;
	}

}
