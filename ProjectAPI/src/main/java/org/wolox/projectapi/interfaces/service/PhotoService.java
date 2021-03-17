package org.wolox.projectapi.interfaces.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wolox.projectapi.domain.Album;
import org.wolox.projectapi.domain.Photo;
import org.wolox.projectapi.interfaces.client.ApiExternalClient;
import org.wolox.projectapi.interfaces.client.IPhoto;

@Service
public class PhotoService implements IPhoto {
	
	@Autowired
	ApiExternalClient api;
	
    public List<Photo> getPhotosByUser (String idUser) {
		
    	List<Album> albums = api.getAlbumsByUser(idUser).getBody();
    	List<Photo> photosByAlbumUser = new ArrayList<>();
    	List<List<Photo>> photosByUser=new ArrayList<>();
    	Iterator<List<Photo>> iter = photosByUser.iterator();
    	
    	for(Album a :albums) {
    		photosByAlbumUser= api.getPhotosByAlbum(String.valueOf(a.getId())).getBody();
    		photosByUser.add(photosByAlbumUser);
    		photosByAlbumUser.clear();
    	}
    	
    	while(iter.hasNext()){
    	    Iterator<Photo> photoIter = iter.next().iterator();
    	    while(photoIter.hasNext()){
    	    	Photo photo = photoIter.next();
    	    	photosByAlbumUser.add(photo);
    	     }
    	}
    

    	return photosByAlbumUser;
		
	}
	

    public List<Photo> getPhotos(){
    	
    	return api.getPhotos().getBody();
    }


}
