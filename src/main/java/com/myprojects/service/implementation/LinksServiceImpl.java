package com.myprojects.service.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.entity.Links;
import com.myprojects.repository.LinksRepository;
import com.myprojects.service.LinksService;

@Service
public class LinksServiceImpl implements LinksService{

	Logger log = LoggerFactory.getLogger(LinksServiceImpl.class);
	
	@Autowired
	private LinksRepository repository;
	
	@Override
	public Links saveLinks(Links links) {
		if(links != null) {
			return repository.save(links);
		}
		return new Links();
	}

	@Override
	public List<Links> getAllLinks() {
		List<Links> list = repository.findByOrderByCategoriesAsc(); 
		if(list.isEmpty()) {
			log.info("list is empty");
			return null;
		}
		log.info("list:", list);
		return list;
	}

	@Override
	public List<Links> getLinksByType(String type){
		List<Links> list = repository.findLinksByType(type);
		
		if(list == null) {
			return null;
		}
		return list;
	}
	
	@Override
	public Links getLinksById(String id) {
		
		return repository.findById(id);
	}
	
	@Override
	public List<Links> findByLinkName(String linkName) {
		
		return repository.findByLinkName(linkName);
	}

	@Override
	public Links updateLink(Links links, String linkName) {
		List<Links> link = repository.findByLinkName(linkName);
		if(link != null) {
			return repository.save(links);
		}
			return new Links();
	}

	@Override
	public void deleteLinks(String linkName) {
		List<Links> link = repository.findByLinkName(linkName);
		if(link != null) {
			repository.deleteByLinkName(linkName);
		}
			new Links();
	}
}
