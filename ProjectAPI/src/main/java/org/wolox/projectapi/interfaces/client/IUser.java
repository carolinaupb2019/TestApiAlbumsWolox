package org.wolox.projectapi.interfaces.client;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.wolox.projectapi.domain.Post;
import org.wolox.projectapi.domain.SharedAlbum;
import org.wolox.projectapi.domain.User;

public interface IUser {
	
    ResponseEntity<List<User>> getUsers();
	
    ResponseEntity<List<Post>> getPosts();
    
	ResponseEntity<Set<Integer>> searchUsersByAlbumPermissions(SharedAlbum sharedAlbum, String permission);

}
