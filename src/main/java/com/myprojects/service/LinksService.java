package com.myprojects.service;

import java.util.List;

import com.myprojects.entity.Links;

public interface LinksService {

	Links saveLinks(Links links);
	
	List<Links> getAllLinks();
	
	Links getLinksById(String id);
	
	List<Links> getLinksByType(String type);
	
	List<Links> findByLinkName(String linkName);
	
	Links updateLink(Links link, String url);
	
	void deleteLinks(String url);
}
