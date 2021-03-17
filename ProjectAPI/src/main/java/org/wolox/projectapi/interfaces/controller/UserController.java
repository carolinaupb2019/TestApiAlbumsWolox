package org.wolox.projectapi.interfaces.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wolox.projectapi.domain.Post;
import org.wolox.projectapi.domain.SharedAlbum;
import org.wolox.projectapi.domain.User;
import org.wolox.projectapi.interfaces.client.IUser;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	IUser iUser;
	
	@ApiOperation(value = "Get all users info")
    @GetMapping(value = "/allusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers () {
		
		return iUser.getUsers();
	}
	
	@ApiOperation(value = "Get all post ")
    @GetMapping(value = "/allposts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getPosts () {
		
		return iUser.getPosts();
	}
	

	
	@ApiOperation(value = "Search user's by album and permission allowed")
    @GetMapping(value = "/searchUsersByAlbumPermissions/{idAlbum}/{permission}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Integer>> searchUsersByAlbumPermissions
    (@ApiParam(value = "id album required", required = true) @PathVariable int idAlbum,
     @ApiParam(value = "it depends permission required string READ or WRITE", required = true) @PathVariable String permission){
		
		SharedAlbum sharedAlbum= new SharedAlbum();
		sharedAlbum.setIdAlbum(idAlbum);
	
		return 	iUser.searchUsersByAlbumPermissions(sharedAlbum, permission);
	}

}
