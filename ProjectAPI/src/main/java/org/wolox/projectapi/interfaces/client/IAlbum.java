package org.wolox.projectapi.interfaces.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.wolox.projectapi.domain.Album;
import org.wolox.projectapi.domain.SharedAlbum;

public interface IAlbum {
	
	ResponseEntity<List<Album>> getAlbums();
	
	ResponseEntity<List<Album>> getAlbumsByUser(String idUser);
	
	ResponseEntity<SharedAlbum> createSharedAlbum(SharedAlbum sharedAlbum);
	
	ResponseEntity<SharedAlbum> updateSharedAlbum(SharedAlbum sharedAlbum);

}
