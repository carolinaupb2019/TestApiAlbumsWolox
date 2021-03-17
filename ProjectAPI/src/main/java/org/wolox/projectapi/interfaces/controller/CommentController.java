package org.wolox.projectapi.interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wolox.projectapi.domain.Comment;
import org.wolox.projectapi.interfaces.client.IComment;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RequestMapping("/comments")
@RestController
public class CommentController {
	
	@Autowired
	IComment icomment ;
	
	@ApiOperation(value = "Get user's comments by name")
    @GetMapping(value = "/commentsByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getComments
    (@ApiParam(value = "User's comments", required = true) @PathVariable String name){
		
		return new ResponseEntity<> (icomment.getCommentsByName(name), HttpStatus.OK);
	}
	

}
