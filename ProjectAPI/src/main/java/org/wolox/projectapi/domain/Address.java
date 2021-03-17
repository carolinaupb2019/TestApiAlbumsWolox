package org.wolox.projectapi.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {


	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
	
}
