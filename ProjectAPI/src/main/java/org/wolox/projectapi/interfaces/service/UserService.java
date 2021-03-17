package org.wolox.projectapi.interfaces.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.wolox.projectapi.domain.Post;
import org.wolox.projectapi.domain.SharedAlbum;
import org.wolox.projectapi.domain.User;
import org.wolox.projectapi.interfaces.client.ApiExternalClient;
import org.wolox.projectapi.interfaces.client.IUser;
import org.wolox.projectapi.repository.SharedAlbumRepository;

@Service
public class UserService implements IUser {
	
	@Autowired
	ApiExternalClient api;
	
	@Autowired
	private SharedAlbumRepository sharedAlbumRepository;
	
	static final String PERMISSION_READ="READ";
	
	static final String PERMISSION_WRITE="WRITE";
	
    public ResponseEntity<List<User>> getUsers () {
		
		return api.getUsers();
	}
	
    public ResponseEntity<List<Post>> getPosts (){
		
		return api.getPosts();
	}
    
    public ResponseEntity<Set<Integer>> searchUsersByAlbumPermissions(SharedAlbum sharedAlbum, String permission){
    	
    	List<SharedAlbum> albumsByUserPermissions= new ArrayList<SharedAlbum>();
    	Set<Integer> usersByAlbumPermissions = new HashSet<>();
    	
    	if(permission.equals(PERMISSION_READ)) {
    		albumsByUserPermissions= sharedAlbumRepository.findByIdAlbumAndReadAllow(sharedAlbum.getIdAlbum(), true);
    	}

    	if(permission.equals(PERMISSION_WRITE)) {
    		albumsByUserPermissions= sharedAlbumRepository.findByIdAlbumAndWriteAllow(sharedAlbum.getIdAlbum(), true);
    	}
    	
    	for(SharedAlbum album:albumsByUserPermissions) {
    	    usersByAlbumPermissions.add(album.getIdUser());
    	}
    		
    	return new ResponseEntity<Set<Integer>>(usersByAlbumPermissions, HttpStatus.OK);
    }

}
