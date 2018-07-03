package org.deie.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deie.model.Lecturer;
import org.deie.model.ResearchAndDevelopment;
import org.kadupitiya.dbhandler.DBConnectionManager;

public class StaffLoader {

	private List<Lecturer> pageList;
	private Lecturer selectedLecturer;
	private Lecturer departmentHead;

	public StaffLoader() {

	}

	public boolean getPageListValues() {

		java.sql.ResultSet resultset1, resultset2, resultset3, resultset4, resultset5, resultset6;

		try {

			String statement = "SELECT DISTINCT * FROM staff Where isDisable='0' ORDER BY sortOrder";

			resultset1 = DBConnectionManager.getResult(statement);

			pageList = new ArrayList<Lecturer>();

			String link = "assets/images/staff/";

			while (resultset1.next()) {

				Lecturer lecturer = new Lecturer();
				lecturer.setLecturerId(resultset1.getInt("lecturerId"));
				lecturer.setName(resultset1.getString("name"));
				lecturer.setDesignation(resultset1.getString("designation"));
				lecturer.setAcademicQulifications(resultset1.getString("academicQulifications"));
				lecturer.setEmail(resultset1.getString("email"));
				lecturer.setTelephone(resultset1.getString("telephone"));
				lecturer.setDescription(resultset1.getString("description"));
				lecturer.setAreaOfInterest(resultset1.getString("areaOfInterest"));
				lecturer.setProfessionalQualifications(resultset1.getString("professionalQualifications"));
				lecturer.setModulesTought(resultset1.getString("modulesTought"));
				lecturer.setPublications(resultset1.getString("publications"));
				lecturer.setIshead(resultset1.getInt("ishead"));
				lecturer.setImageName(resultset1.getString("imageName"));
				lecturer.setImageLink(link + resultset1.getString("imageName"));
				lecturer.setIsDisable(resultset1.getInt("isDisable"));
				lecturer.setSortOrder(resultset1.getInt("sortOrder"));
				lecturer.setLinkedin(resultset1.getString("linkedin"));
				lecturer.setGooglePlus(resultset1.getString("googlePlus"));
				lecturer.setFacebook(resultset1.getString("facebook"));

				String statement2 = "SELECT DISTINCT * FROM AssignedProject Where lecturerId='"
						+ resultset1.getInt("lecturerId") + "' or CoSupervisor='" + resultset1.getInt("lecturerId")
						+ "' ORDER BY researchId DESC";

				resultset2 = DBConnectionManager.getResult(statement2);

				List<ResearchAndDevelopment> reasearchList = new ArrayList<ResearchAndDevelopment>();

				while (resultset2.next()) {

					String statement3 = "SELECT DISTINCT * FROM ResearchAndDevelopment Where isDisable='0' and researchId='"
							+ resultset2.getInt("researchId") + "'";

					resultset3 = DBConnectionManager.getResult(statement3);

					

					while (resultset3.next()) {

						ResearchAndDevelopment temp = new ResearchAndDevelopment();
						
						temp.setResearchId(resultset3.getInt("researchId"));
						temp.setTopic(resultset3.getString("topic"));
						temp.setImageName(link + resultset1.getString("imageName"));
						temp.setYouTubeLink(resultset3.getString("youTubeLink"));
						temp.setAbstractDetails(resultset3.getString("abstractDetails"));
						temp.setWebsiteLink(resultset3.getString("websiteLink"));
						temp.setKeywords(resultset3.getString("keywords"));
						temp.setMemberNames(resultset3.getString("memberNames"));
						temp.setDate(resultset3.getString("date"));
						temp.setImageCount(resultset3.getInt("imageCount"));
						temp.setIsDisable(resultset3.getInt("isDisable"));
						temp.setDescription(resultset3.getString("description"));

						//// KFLKAJFLKSAJLFJAS;JF

						String statement4 = "SELECT DISTINCT * FROM AssignedProject Where researchId='"
								+ resultset3.getInt("researchId") + "'";

						resultset4 = DBConnectionManager.getResult(statement4);

						while (resultset4.next()) {

							Map<Integer, String> supervisor = new HashMap<Integer, String>();
							List<Integer> nSupervisor = new ArrayList<Integer>();

							int lectId = resultset4.getInt("lecturerId");
							int supId = resultset4.getInt("CoSupervisor");

							String statement5 = "SELECT name FROM staff WHERE lecturerId=" + lectId;
							String statement6 = "SELECT name FROM staff WHERE lecturerId=" + supId;

							resultset5 = DBConnectionManager.getResult(statement5);

							while (resultset5.next()) {
								supervisor.put(lectId, resultset5.getString("name"));
								nSupervisor.add(lectId);
							}

							resultset6 = DBConnectionManager.getResult(statement6);

							while (resultset6.next()) {
								supervisor.put(supId, resultset6.getString("name"));
								nSupervisor.add(supId);
							}

							temp.setSupervisor(supervisor);
							temp.setnSupervisor(nSupervisor);

						}

						reasearchList.add(temp);

					}

					

				}

				lecturer.setReasearchList(reasearchList);

				if (lecturer.getIshead() == 1) {

					departmentHead = lecturer;

				}

				pageList.add(lecturer);

			}

			if (pageList.size() > 0) {

				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}

	public boolean getSingleLecturer(String index) {

		java.sql.ResultSet resultset1, resultset2, resultset3, resultset4, resultset5, resultset6;

		try {
			String statement = "";

			statement = "SELECT * FROM staff WHERE lecturerId=" + index;

			resultset1 = DBConnectionManager.getResult(statement);

			String link = "assets/images/staff/";

			String link2 = "assets/images/researchanddevelopment/";

			while (resultset1.next()) {

				Lecturer lecturer = new Lecturer();
				lecturer.setLecturerId(resultset1.getInt("lecturerId"));
				lecturer.setName(resultset1.getString("name"));
				lecturer.setDesignation(resultset1.getString("designation"));
				lecturer.setAcademicQulifications(resultset1.getString("academicQulifications"));
				lecturer.setEmail(resultset1.getString("email"));
				lecturer.setTelephone(resultset1.getString("telephone"));
				lecturer.setDescription(resultset1.getString("description"));
				lecturer.setAreaOfInterest(resultset1.getString("areaOfInterest"));
				lecturer.setProfessionalQualifications(resultset1.getString("professionalQualifications"));
				lecturer.setModulesTought(resultset1.getString("modulesTought"));
				lecturer.setPublications(resultset1.getString("publications"));
				lecturer.setIshead(resultset1.getInt("ishead"));
				lecturer.setImageName(resultset1.getString("imageName"));
				lecturer.setImageLink(link + resultset1.getString("imageName"));
				lecturer.setIsDisable(resultset1.getInt("isDisable"));
				lecturer.setSortOrder(resultset1.getInt("sortOrder"));
				lecturer.setLinkedin(resultset1.getString("linkedin"));
				lecturer.setGooglePlus(resultset1.getString("googlePlus"));
				lecturer.setFacebook(resultset1.getString("facebook"));

				String statement2 = "SELECT DISTINCT * FROM AssignedProject Where lecturerId='"
						+ resultset1.getInt("lecturerId") + "' or CoSupervisor='" + resultset1.getInt("lecturerId")
						+ "' ORDER BY researchId DESC";

				resultset2 = DBConnectionManager.getResult(statement2);

				List<ResearchAndDevelopment> reasearchList = new ArrayList<ResearchAndDevelopment>();

				while (resultset2.next()) {

					String statement3 = "SELECT DISTINCT * FROM ResearchAndDevelopment Where isDisable='0' and researchId='"
							+ resultset2.getInt("researchId") + "'";

					resultset3 = DBConnectionManager.getResult(statement3);

					

					while (resultset3.next()) {

						ResearchAndDevelopment temp = new ResearchAndDevelopment();
						
						temp.setResearchId(resultset3.getInt("researchId"));
						temp.setTopic(resultset3.getString("topic"));
						temp.setImageName(link2 + resultset3.getString("imageName"));
						temp.setYouTubeLink(resultset3.getString("youTubeLink"));
						temp.setAbstractDetails(resultset3.getString("abstractDetails"));
						temp.setWebsiteLink(resultset3.getString("websiteLink"));
						temp.setKeywords(resultset3.getString("keywords"));
						temp.setMemberNames(resultset3.getString("memberNames"));
						temp.setDate(resultset3.getString("date"));
						temp.setImageCount(resultset3.getInt("imageCount"));
						temp.setIsDisable(resultset3.getInt("isDisable"));
						temp.setDescription(resultset3.getString("description"));

						String statement4 = "SELECT DISTINCT * FROM AssignedProject Where researchId='"
								+ resultset3.getInt("researchId") + "'";

						resultset4 = DBConnectionManager.getResult(statement4);

						while (resultset4.next()) {

							Map<Integer, String> supervisor = new HashMap<Integer, String>();
							List<Integer> nSupervisor = new ArrayList<Integer>();

							int lectId = resultset4.getInt("lecturerId");
							int supId = resultset4.getInt("CoSupervisor");

							String statement5 = "SELECT name FROM staff WHERE lecturerId=" + lectId;
							String statement6 = "SELECT name FROM staff WHERE lecturerId=" + supId;

							resultset5 = DBConnectionManager.getResult(statement5);

							while (resultset5.next()) {
								supervisor.put(lectId, resultset5.getString("name"));
								nSupervisor.add(lectId);
							}

							resultset6 = DBConnectionManager.getResult(statement6);

							while (resultset6.next()) {
								supervisor.put(supId, resultset6.getString("name"));
								nSupervisor.add(supId);
							}

							temp.setSupervisor(supervisor);
							temp.setnSupervisor(nSupervisor);
							
						}
						reasearchList.add(temp);
					}

					

				}

				lecturer.setReasearchList(reasearchList);

				selectedLecturer = lecturer;

			}

			if (selectedLecturer != null) {

				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}

	public Lecturer getSelectedLecturer() {
		return selectedLecturer;
	}

	public void setSelectedLecturer(Lecturer selectedLecturer) {
		this.selectedLecturer = selectedLecturer;
	}

	public Lecturer getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(Lecturer departmentHead) {
		this.departmentHead = departmentHead;
	}

	public void setPageList(List<Lecturer> pageList) {
		this.pageList = pageList;
	}

	public List<Lecturer> getPageList() {
		return pageList;
	}

}
