package org.deie.model;

public class News {

	private String imageName;
	private String title;
	private String description;
	private int newsId;
	private String imageLink;
	private int isDisable;
	private int imageCount;
	
	public News() {
		isDisable=0;
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

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}
	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}
	
}
