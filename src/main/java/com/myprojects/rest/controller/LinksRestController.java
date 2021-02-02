package com.myprojects.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.entity.Links;
import com.myprojects.service.implementation.LinksServiceImpl;

@RestController		//context-path added in application.properties
@RequestMapping("/api/links")
public class LinksRestController {

	@Autowired
	private LinksServiceImpl service;
	
	//---------------------------------------------------------------------add a link 
	@PostMapping
	public Links saveLink(@RequestBody Links links) {
		Links link = service.saveLinks(links);
		return link;
	}
		
	//---------------------------------------------------------------------get all links
	@GetMapping
	public List<Links> getLinks(){
		return service.getAllLinks();
	}
	
	//---------------------------------------------------------------------get a link by id
//	@GetMapping("/{id}")
//	public Links getLinksById(@PathVariable String id){
//		return service.getLinksById(id);
//	}
	
	//---------------------------------------------------------------------get a link by type = tool
	@GetMapping("/{type}")
	public List<Links> getLinksByType(@PathVariable("type") String type){
		return service.getLinksByType(type);
	}
	//---------------------------------------------------------------------update link
	@PutMapping("/name/{linkName}")
	public Links UpdateLink(@PathVariable("linkName") String linkName, @RequestBody Links links){
		return service.updateLink(links, linkName);
	}
	//---------------------------------------------------------------------delete
	@DeleteMapping("/name/{linkName}")
	public void DeleteLink(@PathVariable("linkName") String linkName) {
		service.deleteLinks(linkName);
	}
	
	//---------------------------------------------------------------------get a link by name
	@GetMapping("/name/{linkName}")
	public List<Links> findByName(@PathVariable String linkName){
		return service.findByLinkName(linkName);
	}
	//---------------------------------------------------------------------update
//	@PutMapping("/links/{linkName}")
//	public Links update(@RequestBody Links link, @PathVariable String linkName) {
//		return service.updateLink(link, linkName);
//	}
	
	//delete
//	@DeleteMapping("/links/{linkName}")
//	public void delete(@PathVariable String  linkName) {
//		service.deleteLinks(linkName);
//	}
}
