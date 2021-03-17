package org.wolox.projectapi.interfaces.client;

import java.util.List;

import org.wolox.projectapi.domain.Photo;

public interface IPhoto {
	
	 List<Photo> getPhotos();
	
	 List<Photo> getPhotosByUser(String idUser);

}
