package com.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommend {
	@Autowired
	
	private MovieCatalog movieCatalog;
	
	public void recommend() {
		System.out.println("Type: "+movieCatalog.getCat());
		movieCatalog.showMovie();
	}
}
