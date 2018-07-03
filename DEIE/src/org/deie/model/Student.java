package org.deie.model;



import javax.xml.bind.annotation.XmlRootElement;

public class Student {

	private String imageName;
	private String title;
	private String description;
	private String newsId;
	
	
	public Student(){
		
		
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNewsId() {
		return newsId;
	}


	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	
	
	
	
}
