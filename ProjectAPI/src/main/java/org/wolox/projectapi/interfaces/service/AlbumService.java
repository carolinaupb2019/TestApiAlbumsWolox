package org.wolox.projectapi.interfaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.wolox.projectapi.domain.Album;
import org.wolox.projectapi.domain.SharedAlbum;
import org.wolox.projectapi.interfaces.client.ApiExternalClient;
import org.wolox.projectapi.interfaces.client.IAlbum;
import org.wolox.projectapi.repository.SharedAlbumRepository;

@Service
public class AlbumService implements IAlbum{
	
	@Autowired
	ApiExternalClient api;
	
	@Autowired
	private SharedAlbumRepository sharedAlbumRepository;
	
    public ResponseEntity<List<Album>> getAlbums () {
		
		return api.getAlbums();
	}
	
    public ResponseEntity<List<Album>> getAlbumsByUser(String idUser){
		
		return api.getAlbumsByUser(idUser);
	}

    public ResponseEntity<SharedAlbum> createSharedAlbum(SharedAlbum sharedAlbum){
		
    	SharedAlbum sharedAlbumSaved= (SharedAlbum) sharedAlbumRepository.save(sharedAlbum);
		
    	return new ResponseEntity<>(sharedAlbumSaved, HttpStatus.OK);
				
	}
    
    public ResponseEntity<SharedAlbum> updateSharedAlbum(SharedAlbum sharedAlbum){
		
    	SharedAlbum sharedAlbumUpdated = new SharedAlbum();
    	SharedAlbum sharedAlbumFinded= (SharedAlbum) sharedAlbumRepository.findByIdAlbumAndIdUser(sharedAlbum.getIdAlbum(), sharedAlbum.getIdUser());
    	sharedAlbumUpdated.setIdSharedAlbum(sharedAlbumFinded.getIdSharedAlbum());
    	sharedAlbumUpdated.setIdUser(sharedAlbumFinded.getIdUser());
    	sharedAlbumUpdated.setIdAlbum(sharedAlbumFinded.getIdAlbum());
    	sharedAlbumUpdated.setReadAllow(sharedAlbum.isReadAllow());
    	sharedAlbumUpdated.setWriteAllow(sharedAlbum.isWriteAllow());
    	sharedAlbumUpdated= sharedAlbumRepository.save(sharedAlbumUpdated);
				
    	return new ResponseEntity<>(sharedAlbumUpdated, HttpStatus.OK);
				
	}
    
}
