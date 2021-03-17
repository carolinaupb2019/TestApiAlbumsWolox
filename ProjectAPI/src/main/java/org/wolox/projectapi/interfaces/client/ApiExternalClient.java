package org.wolox.projectapi.interfaces.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wolox.projectapi.domain.Album;
import org.wolox.projectapi.domain.Comment;
import org.wolox.projectapi.domain.Photo;
import org.wolox.projectapi.domain.Post;
import org.wolox.projectapi.domain.User;

@FeignClient(name = "${feign.client.name}", url ="${feign.client.url}")
public interface ApiExternalClient {

	  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<User>> getUsers();
	  
	  @GetMapping(value = "/photos", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<Photo>> getPhotos();
	  
	  @GetMapping(value = "/albums", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<Album>> getAlbums();
	  
	  //Photos every album
	  @GetMapping(value = "/albums/{id}/photos", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<Photo>> getPhotosByAlbum(@PathVariable("idAlbum") String idAlbum);
	  	  
	  //Albums every user
	  @GetMapping(value = "/users/{id}/albums", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<Album>> getAlbumsByUser(@PathVariable("id") String idUser);
	  
	  @GetMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<Comment>> getComments();
	   
	  @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
	  ResponseEntity<List<Post>> getPosts();

    
}
