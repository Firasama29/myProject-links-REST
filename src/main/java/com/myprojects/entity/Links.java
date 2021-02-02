package com.myprojects.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Links implements Serializable{

	private static final long serialVersionUID = 3452922747832561537L;

	@Id
	private String id;
	@NotBlank
	private String linkName;
	
	private String url;
	
	private String description; 
	
	private List<String> categories;
	
	@NotBlank
	private String type;
	
	public Links() {}
	
	public Links(String id, @NotBlank String linkName, @NotBlank String type, String url, String description,
			List<String> categories) {
		super();
		this.id = UUID.randomUUID().toString();
		this.linkName = linkName;
		this.type = type;
		this.url = url;
		this.description = description;
		this.categories = categories;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id =  id;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, linkName, type, url, description, categories);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Links))
			return false;
		Links links = (Links) obj;
		return Objects.equals(linkName, links.linkName) && Objects.equals(url, links.url);
	}

	@Override
	public String toString() {
		return "Websites [id=" + id + ", linkName=" + linkName + ", categories=" + categories + ", description=" + description
				+ ", type=" + type + ", url=" + url + "]";
				
	}
	
}
