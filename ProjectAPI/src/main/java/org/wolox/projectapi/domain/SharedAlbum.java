package org.wolox.projectapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"idAlbum","idUser"})})
@Getter
@Setter
public class SharedAlbum  implements Serializable{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int idSharedAlbum;

	  private int idAlbum;

	  private int idUser;
	  
	  private boolean readAllow;
	  
	  private boolean writeAllow;
	

}
