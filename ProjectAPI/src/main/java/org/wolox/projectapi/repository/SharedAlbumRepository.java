package org.wolox.projectapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wolox.projectapi.domain.SharedAlbum;

@Repository
public interface SharedAlbumRepository extends org.springframework.data.repository.CrudRepository<SharedAlbum, Integer>{
	
   Object findByIdAlbumAndIdUser(int idAlbum, int idUser);
   
   List<SharedAlbum> findByIdAlbumAndReadAllow(int idAlbum, boolean readAllow);
   
   List<SharedAlbum> findByIdAlbumAndWriteAllow(int idAlbum, boolean writeAllow);
  
}
