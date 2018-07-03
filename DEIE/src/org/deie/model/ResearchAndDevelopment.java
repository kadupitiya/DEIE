package org.deie.model;

import java.util.List;
import java.util.Map;

public class ResearchAndDevelopment {

	private int researchId;
	private String topic;
	private String imageName;
	private String youTubeLink;
	private String abstractDetails;
	private String websiteLink;
	private String keywords;
	private String memberNames;
	private String date;
	private int imageCount;
	private int isDisable;
	private String description;
	private Map<Integer, String> supervisor;
	private List<Integer> nSupervisor;

	public ResearchAndDevelopment() {

		isDisable = 0;
	}

	public int getResearchId() {
		return researchId;
	}

	public void setResearchId(int researchId) {
		this.researchId = researchId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getYouTubeLink() {
		return youTubeLink;
	}

	public void setYouTubeLink(String youTubeLink) {
		this.youTubeLink = youTubeLink;
	}

	public String getAbstractDetails() {
		return abstractDetails;
	}

	public void setAbstractDetails(String abstractDetails) {
		this.abstractDetails = abstractDetails;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMemberNames() {
		return memberNames;
	}

	public void setMemberNames(String memberNames) {
		this.memberNames = memberNames;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}

	public int getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Integer, String> getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Map<Integer, String> supervisor) {
		this.supervisor = supervisor;
	}

	public List<Integer> getnSupervisor() {
		return nSupervisor;
	}

	public void setnSupervisor(List<Integer> nSupervisor) {
		this.nSupervisor = nSupervisor;
	}

}
