package org.deie.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deie.model.ResearchAndDevelopment;
import org.kadupitiya.dbhandler.DBConnectionManager;

public class ResearchAndDevelopmentLoader {

	private List<ResearchAndDevelopment> researchAndDevelopmentPage;
	int researchAndDevelopmentPageCount = 10;
	int loadMoreValue = 0;
	private ResearchAndDevelopment specialRND;

	public ResearchAndDevelopmentLoader() {

	}

	public boolean getResearchAndDevelopmentPageList(int loadMoreValue) {

		this.loadMoreValue = loadMoreValue;

		java.sql.ResultSet resultset1, resultset2, resultset3, resultset4;

		try {
			String statement = "";
			if (loadMoreValue == 0) {

				statement = "SELECT DISTINCT * FROM ResearchAndDevelopment Where isDisable='0' ORDER BY researchId DESC LIMIT "
						+ researchAndDevelopmentPageCount;

			} else {

				statement = "SELECT DISTINCT * FROM ResearchAndDevelopment Where isDisable='0' ORDER BY researchId DESC LIMIT "
						+ loadMoreValue;

			}

			resultset1 = DBConnectionManager.getResult(statement);

			researchAndDevelopmentPage = new ArrayList<ResearchAndDevelopment>();

			String link = "assets/images/researchanddevelopment/";

			while (resultset1.next()) {

				ResearchAndDevelopment researchAndDevelopment = new ResearchAndDevelopment();

				researchAndDevelopment.setResearchId(resultset1.getInt("researchId"));
				researchAndDevelopment.setTopic(resultset1.getString("topic"));
				researchAndDevelopment.setImageName(link + resultset1.getString("imageName"));
				researchAndDevelopment.setYouTubeLink(resultset1.getString("youTubeLink"));
				researchAndDevelopment.setAbstractDetails(resultset1.getString("abstractDetails"));
				researchAndDevelopment.setWebsiteLink(resultset1.getString("websiteLink"));
				researchAndDevelopment.setKeywords(resultset1.getString("keywords"));
				researchAndDevelopment.setMemberNames(resultset1.getString("memberNames"));
				researchAndDevelopment.setDate(resultset1.getString("date"));
				researchAndDevelopment.setImageCount(resultset1.getInt("imageCount"));
				researchAndDevelopment.setIsDisable(resultset1.getInt("isDisable"));
				researchAndDevelopment.setDescription(resultset1.getString("description"));

				String statement2 = "SELECT DISTINCT * FROM AssignedProject Where researchId='"
						+ resultset1.getInt("researchId") + "'";

				resultset2 = DBConnectionManager.getResult(statement2);

				while (resultset2.next()) {

					Map<Integer, String> supervisor = new HashMap<Integer, String>();
					List<Integer> nSupervisor = new ArrayList<Integer>();

					int lectId = resultset2.getInt("lecturerId");
					int supId = resultset2.getInt("CoSupervisor");

					String statement3 = "SELECT name FROM staff WHERE lecturerId=" + lectId;
					String statement4 = "SELECT name FROM staff WHERE lecturerId=" + supId;

					resultset3 = DBConnectionManager.getResult(statement3);

					while (resultset3.next()) {
						supervisor.put(lectId, resultset3.getString("name"));
						nSupervisor.add(lectId);
					}

					resultset4 = DBConnectionManager.getResult(statement4);

					while (resultset4.next()) {
						supervisor.put(supId, resultset4.getString("name"));
						nSupervisor.add(supId);
					}

					researchAndDevelopment.setSupervisor(supervisor);
					researchAndDevelopment.setnSupervisor(nSupervisor);

				}

				researchAndDevelopmentPage.add(researchAndDevelopment);

			}

			if (researchAndDevelopmentPage.size() > 0) {

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

	public boolean getSingleResearchAndDevelopment(String index) {

		java.sql.ResultSet resultset1, resultset2, resultset3, resultset4;

		try {
			String statement = "";

			statement = "SELECT * FROM ResearchAndDevelopment WHERE researchId=" + index;

			resultset1 = DBConnectionManager.getResult(statement);

			String link = "assets/images/researchanddevelopment/";

			specialRND = new ResearchAndDevelopment();

			while (resultset1.next()) {

				specialRND.setResearchId(resultset1.getInt("researchId"));
				specialRND.setTopic(resultset1.getString("topic"));
				specialRND.setImageName(link + resultset1.getString("imageName"));
				specialRND.setYouTubeLink(resultset1.getString("youTubeLink"));
				specialRND.setAbstractDetails(resultset1.getString("abstractDetails"));
				specialRND.setWebsiteLink(resultset1.getString("websiteLink"));
				specialRND.setKeywords(resultset1.getString("keywords"));
				specialRND.setMemberNames(resultset1.getString("memberNames"));
				specialRND.setDate(resultset1.getString("date"));
				specialRND.setImageCount(resultset1.getInt("imageCount"));
				specialRND.setIsDisable(resultset1.getInt("isDisable"));
				specialRND.setDescription(resultset1.getString("description"));

				String statement2 = "SELECT DISTINCT * FROM AssignedProject Where researchId='"
						+ resultset1.getInt("researchId") + "'";

				resultset2 = DBConnectionManager.getResult(statement2);

				while (resultset2.next()) {

					Map<Integer, String> supervisor = new HashMap<Integer, String>();
					List<Integer> nSupervisor = new ArrayList<Integer>();

					int lectId = resultset2.getInt("lecturerId");
					int supId = resultset2.getInt("CoSupervisor");

					String statement3 = "SELECT name FROM staff WHERE lecturerId=" + lectId;
					String statement4 = "SELECT name FROM staff WHERE lecturerId=" + supId;

					resultset3 = DBConnectionManager.getResult(statement3);

					while (resultset3.next()) {
						supervisor.put(lectId, resultset3.getString("name"));
						nSupervisor.add(lectId);
					}

					resultset4 = DBConnectionManager.getResult(statement4);

					while (resultset4.next()) {
						supervisor.put(supId, resultset4.getString("name"));
						nSupervisor.add(supId);
					}

					specialRND.setSupervisor(supervisor);
					specialRND.setnSupervisor(nSupervisor);

				}

			}

			if (specialRND != null) {

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

	public List<ResearchAndDevelopment> getResearchAndDevelopmentPage() {
		return researchAndDevelopmentPage;
	}

	public void setResearchAndDevelopmentPage(List<ResearchAndDevelopment> ResearchAndDevelopmentPage) {
		this.researchAndDevelopmentPage = ResearchAndDevelopmentPage;
	}

	public int getResearchAndDevelopmentPageCount() {
		return researchAndDevelopmentPageCount;
	}

	public void setResearchAndDevelopmentPageCount(int ResearchAndDevelopmentPageCount) {
		this.researchAndDevelopmentPageCount = ResearchAndDevelopmentPageCount;
	}

	public int getLoadMoreValue() {
		return loadMoreValue;
	}

	public void setLoadMoreValue(int loadMoreValue) {
		this.loadMoreValue = loadMoreValue;
	}

	public ResearchAndDevelopment getSpecialRND() {
		return specialRND;
	}

	public void setSpecialRND(ResearchAndDevelopment specialRND) {
		this.specialRND = specialRND;
	}

}
