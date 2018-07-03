package org.deie.model;

public class SpecialNotice {

	private String imageName;
	private String title;
	private String description;
	private int specialNoticeId;
	private String imageLink;
	private int isDisable;
	private int imageCount;


	public SpecialNotice() {
		isDisable=0;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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

	public int getSpecialNoticeId() {
		return specialNoticeId;
	}

	public void setSpecialNoticeId(int specialNoticeId) {
		this.specialNoticeId = specialNoticeId;
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
