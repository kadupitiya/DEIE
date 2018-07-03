package org.deie.loader;

import java.util.ArrayList;
import java.util.List;

import org.deie.model.SpecialNotice;
import org.kadupitiya.dbhandler.DBConnectionManager;


public class SpecialNoticeLoader {

	private List<SpecialNotice> homePage;
	int homePageCount = 2;
	private List<SpecialNotice> specialNoticePage;
	int specialNoticePageCount = 8;
	int loadMoreValue = 0;
	private SpecialNotice selectedNotice;

	

	public SpecialNoticeLoader() {

	}

	public boolean getHomePageList() {

		java.sql.ResultSet resultset1;

		try {

			String statement = "SELECT DISTINCT * FROM specialnotice Where isDisable='0' ORDER BY newsId DESC LIMIT " + homePageCount;

			resultset1 = DBConnectionManager.getResult(statement);

			homePage = new ArrayList<SpecialNotice>();

			String link = "assets/images/specialNotice/";

			while (resultset1.next()) {

				SpecialNotice specialNotice = new SpecialNotice();
				specialNotice.setSpecialNoticeId(resultset1.getInt("newsId"));
				specialNotice.setDescription(resultset1.getString("description"));
				specialNotice.setImageLink(link + resultset1.getString("imageName"));
				specialNotice.setImageName(resultset1.getString("imageName"));
				specialNotice.setTitle(resultset1.getString("title"));
				specialNotice.setImageCount(resultset1.getInt("imageCount"));
				homePage.add(specialNotice);

			}

			if (homePage.size() > 0) {

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

	public boolean getSpecialNoticePageList(int loadMoreValue) {

		this.loadMoreValue = loadMoreValue;

		java.sql.ResultSet resultset1;

		try {
			String statement = "";
			if (loadMoreValue == 0) {

				statement = "SELECT DISTINCT * FROM specialnotice Where isDisable='0' ORDER BY newsId DESC LIMIT " + specialNoticePageCount;

			} else {

				statement = "SELECT DISTINCT * FROM specialnotice Where isDisable='0' ORDER BY newsId DESC LIMIT " + loadMoreValue;

			}

			resultset1 = DBConnectionManager.getResult(statement);

			specialNoticePage = new ArrayList<SpecialNotice>();

			String link = "assets/images/specialNotice/";

			while (resultset1.next()) {

				SpecialNotice specialNotice = new SpecialNotice();
				specialNotice.setSpecialNoticeId(resultset1.getInt("newsId"));
				specialNotice.setDescription(resultset1.getString("description"));
				specialNotice.setImageLink(link + resultset1.getString("imageName"));
				specialNotice.setImageName(resultset1.getString("imageName"));
				specialNotice.setTitle(resultset1.getString("title"));
				specialNotice.setImageCount(resultset1.getInt("imageCount"));
				specialNoticePage.add(specialNotice);

			}

			if (specialNoticePage.size() > 0) {

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

	public boolean getSingleSpecialNotice(String index) {

	
		java.sql.ResultSet resultset1;

		try {
			String statement = "";
			

				statement = "SELECT * FROM specialnotice WHERE newsId=" + index;

			

			resultset1 = DBConnectionManager.getResult(statement);

		

			String link = "assets/images/specialNotice/";

			while (resultset1.next()) {

				selectedNotice = new SpecialNotice();
				selectedNotice.setSpecialNoticeId(resultset1.getInt("newsId"));
				selectedNotice.setDescription(resultset1.getString("description"));
				selectedNotice.setImageLink(link + resultset1.getString("imageName"));
				selectedNotice.setImageName(resultset1.getString("imageName"));
				selectedNotice.setTitle(resultset1.getString("title"));
				selectedNotice.setIsDisable(resultset1.getInt("isDisable"));
				selectedNotice.setImageCount(resultset1.getInt("imageCount"));

			}

			if (selectedNotice != null) {

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
	
	
	public List<SpecialNotice> getHomePage() {
		return homePage;
	}

	public void setHomePage(List<SpecialNotice> homePage) {
		this.homePage = homePage;
	}

	public int getHomePageCount() {
		return homePageCount;
	}

	public void setHomePageCount(int homePageCount) {
		this.homePageCount = homePageCount;
	}

	public List<SpecialNotice> getSpecialNoticePage() {
		return specialNoticePage;
	}

	public void setSpecialNoticePage(List<SpecialNotice> specialNoticePage) {
		this.specialNoticePage = specialNoticePage;
	}

	public int getSpecialNoticePageCount() {
		return specialNoticePageCount;
	}

	public void setSpecialNoticePageCount(int specialNoticePageCount) {
		this.specialNoticePageCount = specialNoticePageCount;
	}

	public int getLoadMoreValue() {
		return loadMoreValue;
	}

	public void setLoadMoreValue(int loadMoreValue) {
		this.loadMoreValue = loadMoreValue;
	}
	public SpecialNotice getSelectedNotice() {
		return selectedNotice;
	}

	public void setSelectedNotice(SpecialNotice selectedNotice) {
		this.selectedNotice = selectedNotice;
	}

}
