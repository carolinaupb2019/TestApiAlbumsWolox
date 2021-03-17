package org.wolox.projectapi.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Photo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbnailUrl;
}
