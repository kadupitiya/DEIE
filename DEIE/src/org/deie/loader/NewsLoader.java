package org.deie.loader;

import java.util.ArrayList;
import java.util.List;

import org.deie.model.News;
import org.kadupitiya.dbhandler.DBConnectionManager;

public class NewsLoader {

	
	private List<News> homePage;
	int homePageCount = 4;
	private List<News> newsPage;
	int newsPageCount = 8;
	int loadMoreValue = 0;
	private News selectedNews;

	

	public NewsLoader() {

	}
	
	
	public boolean getHomePageList() {

		java.sql.ResultSet resultset1;

		try {

			String statement = "SELECT DISTINCT * FROM news Where isDisable='0' ORDER BY newsId DESC LIMIT " + homePageCount;

			resultset1 = DBConnectionManager.getResult(statement);

			homePage = new ArrayList<News>();

			String link = "assets/images/news/";

			while (resultset1.next()) {

				News specialNotice = new News();
				specialNotice.setNewsId(resultset1.getInt("newsId"));
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
	public boolean getNewsPageList(int loadMoreValue) {

		this.loadMoreValue = loadMoreValue;

		java.sql.ResultSet resultset1;

		try {
			String statement = "";
			if (loadMoreValue == 0) {

				statement = "SELECT DISTINCT * FROM news Where isDisable='0' ORDER BY newsId DESC LIMIT " + newsPageCount;

			} else {

				statement = "SELECT DISTINCT * FROM news Where isDisable='0' ORDER BY newsId DESC LIMIT " + loadMoreValue;

			}

			resultset1 = DBConnectionManager.getResult(statement);

			newsPage = new ArrayList<News>();

			String link = "assets/images/news/";

			while (resultset1.next()) {

				News specialNotice = new News();
				specialNotice.setNewsId(resultset1.getInt("newsId"));
				specialNotice.setDescription(resultset1.getString("description"));
				specialNotice.setImageLink(link + resultset1.getString("imageName"));
				specialNotice.setImageName(resultset1.getString("imageName"));
				specialNotice.setTitle(resultset1.getString("title"));
				specialNotice.setImageCount(resultset1.getInt("imageCount"));
				newsPage.add(specialNotice);

			}

			if (newsPage.size() > 0) {

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
	public boolean getSingleNews(String index) {

		
		java.sql.ResultSet resultset1;

		try {
			String statement = "";
			

				statement = "SELECT * FROM news WHERE newsId=" + index;

			

			resultset1 = DBConnectionManager.getResult(statement);

		

			String link = "assets/images/news/";

			while (resultset1.next()) {

				selectedNews = new News();
				selectedNews.setNewsId(resultset1.getInt("newsId"));
				selectedNews.setDescription(resultset1.getString("description"));
				selectedNews.setImageLink(link + resultset1.getString("imageName"));
				selectedNews.setImageName(resultset1.getString("imageName"));
				selectedNews.setTitle(resultset1.getString("title"));
				selectedNews.setIsDisable(resultset1.getInt("isDisable"));
				selectedNews.setImageCount(resultset1.getInt("imageCount"));

			}

			if (selectedNews != null) {

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
	public List<News> getHomePage() {
		return homePage;
	}


	public void setHomePage(List<News> homePage) {
		this.homePage = homePage;
	}


	public int getHomePageCount() {
		return homePageCount;
	}


	public void setHomePageCount(int homePageCount) {
		this.homePageCount = homePageCount;
	}


	public List<News> getNewsPage() {
		return newsPage;
	}


	public void setNewsPage(List<News> newsPage) {
		this.newsPage = newsPage;
	}


	public int getNewsPageCount() {
		return newsPageCount;
	}


	public void setNewsPageCount(int newsPageCount) {
		this.newsPageCount = newsPageCount;
	}


	public int getLoadMoreValue() {
		return loadMoreValue;
	}


	public void setLoadMoreValue(int loadMoreValue) {
		this.loadMoreValue = loadMoreValue;
	}


	public News getSelectedNews() {
		return selectedNews;
	}


	public void setSelectedNews(News selectedNews) {
		this.selectedNews = selectedNews;
	}
	
}
