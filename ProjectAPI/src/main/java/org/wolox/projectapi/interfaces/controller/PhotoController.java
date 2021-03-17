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
import org.wolox.projectapi.domain.Photo;
import org.wolox.projectapi.interfaces.client.IPhoto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RequestMapping("/photos")
@RestController
public class PhotoController {
	
	@Autowired
	private IPhoto iPhoto;
	
	@ApiOperation(value = "Get all photos")
    @GetMapping(value = "/allphotos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Photo>> getPhotos(){
		
		return new ResponseEntity<> (iPhoto.getPhotos(), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get user's photos")
    @GetMapping(value = "/photosByUser/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Photo>> getPhotosByUser(
    @ApiParam(value = "User's id", required = true) @PathVariable String idUser){
		
		return new ResponseEntity<> (iPhoto.getPhotosByUser(idUser), HttpStatus.OK);
	}
	
	

}
