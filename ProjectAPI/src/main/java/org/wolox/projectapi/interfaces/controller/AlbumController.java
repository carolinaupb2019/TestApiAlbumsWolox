package org.wolox.projectapi.interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wolox.projectapi.domain.Album;
import org.wolox.projectapi.domain.SharedAlbum;
import org.wolox.projectapi.interfaces.client.IAlbum;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RequestMapping("/albums")
@RestController
public class AlbumController {
	
	@Autowired
	IAlbum iAlbum ;

	
	@ApiOperation(value = "Get album's info")
    @GetMapping(value = "/allAlbums", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAlbums() {
		
		return iAlbum.getAlbums();
	}

	@ApiOperation(value = "Get user's albums")
    @GetMapping(value = "/albumsByUser/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAlbumsByUser
    (@ApiParam(value = "User's albums", required = true) @PathVariable String idUser){
		
		return iAlbum.getAlbumsByUser(idUser);
	}
	

	@ApiOperation(value = "Create shared user's albums")
    @GetMapping(value = "/createSharedAlbum/{idUser}/{idAlbum}/{read}/{write}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SharedAlbum> createSharedAlbum
    (@ApiParam(value = "id user", required = true) @PathVariable int idUser,
     @ApiParam(value = "id album", required = true) @PathVariable int idAlbum,
     @ApiParam(value = "permission read", required = true) @PathVariable boolean read,
     @ApiParam(value = "permission write", required = true) @PathVariable boolean write){
		
		SharedAlbum sharedAlbum= new SharedAlbum();
		sharedAlbum.setIdAlbum(idAlbum);
		sharedAlbum.setIdUser(idUser);
		sharedAlbum.setReadAllow(read);
		sharedAlbum.setWriteAllow(write);
	
		return 	iAlbum.createSharedAlbum(sharedAlbum);
	}
	

	@ApiOperation(value = "Update permissions shared user's albums")
    @PutMapping(value = "/updateSharedAlbum/{idUser}/{idAlbum}/{read}/{write}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SharedAlbum> updateSharedAlbum
    (@ApiParam(value = "id user", required = true) @PathVariable int idUser,
     @ApiParam(value = "id album", required = true) @PathVariable int idAlbum,
     @ApiParam(value = "permission read", required = true) @PathVariable boolean read,
     @ApiParam(value = "permission write", required = true) @PathVariable boolean write){
		
		SharedAlbum sharedAlbum= new SharedAlbum();
		sharedAlbum.setIdAlbum(idAlbum);
		sharedAlbum.setIdUser(idUser);
		sharedAlbum.setReadAllow(read);
		sharedAlbum.setWriteAllow(write);
	
		return 	iAlbum.updateSharedAlbum(sharedAlbum);
	}
	
}
