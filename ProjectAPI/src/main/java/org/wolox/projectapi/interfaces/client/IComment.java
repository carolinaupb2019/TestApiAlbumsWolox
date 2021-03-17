package org.wolox.projectapi.interfaces.client;

import java.util.List;

import org.wolox.projectapi.domain.Comment;

public interface IComment {
	
	List<Comment> getCommentsByName(String name);

}
