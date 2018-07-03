package org.deie.model;

import java.util.List;

public class Lecturer {

	private int lecturerId;
	private String name;
	private String designation;
	private String academicQulifications;
	private String email;
	private String telephone;
	private String description;
	private String areaOfInterest;
	private String professionalQualifications;
	private String modulesTought;
	private String publications;
	private int ishead;
	private String imageName;
	private int isDisable;
	private int sortOrder;
	private String imageLink;
	private String linkedin;
	private String googlePlus;
	private String facebook;
	private List<ResearchAndDevelopment> reasearchList;

	public Lecturer() {
		isDisable = 0;
	}

	public List<ResearchAndDevelopment> getReasearchList() {
		return reasearchList;
	}

	public void setReasearchList(List<ResearchAndDevelopment> reasearchList) {
		this.reasearchList = reasearchList;
	}

	public int getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAcademicQulifications() {
		return academicQulifications;
	}

	public void setAcademicQulifications(String academicQulifications) {
		this.academicQulifications = academicQulifications;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public String getProfessionalQualifications() {
		return professionalQualifications;
	}

	public void setProfessionalQualifications(String professionalQualifications) {
		this.professionalQualifications = professionalQualifications;
	}

	public String getModulesTought() {
		return modulesTought;
	}

	public void setModulesTought(String modulesTought) {
		this.modulesTought = modulesTought;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	public int getIshead() {
		return ishead;
	}

	public void setIshead(int ishead) {
		this.ishead = ishead;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getGooglePlus() {
		return googlePlus;
	}

	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

}
