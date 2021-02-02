package com.myprojects.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myprojects.entity.Links;

@Repository
public interface LinksRepository extends MongoRepository<Links, Long>{

	List<Links> findByOrderByCategoriesAsc();
	
	Links findById(String id);
	
	List<Links> findLinksByType(String type);
	
	List<Links> findByLinkName(String linkName);
	
	List<Links> findByUrl(String url);
	
	void deleteByLinkName(String linkName);
	
}
