package org.deie.controller;

import java.awt.print.Book;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.deie.loader.EmailHandler;
import org.deie.loader.NewsLoader;
import org.deie.loader.ResearchAndDevelopmentLoader;
import org.deie.loader.SpecialNoticeLoader;
import org.deie.loader.StaffLoader;
import org.deie.loader.UserAccountManager;
import org.deie.model.Message;
import org.deie.model.Student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {

	// special Notice
	@RequestMapping(value = "/restRequest/specialNoticeLoad", method = { RequestMethod.POST })
	public @ResponseBody SpecialNoticeLoader specialNoticeLoad(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Object loadMoreValueObject = session.getAttribute("loadMoreValue");
		SpecialNoticeLoader specialNoticeLoader = new SpecialNoticeLoader();
		String parameter2 = request.getParameter("key2");
		int loadMoreValue = 0;
		if (loadMoreValueObject == null || parameter2 == null) {
			loadMoreValue = 0;
			session.setAttribute("loadMoreValue", specialNoticeLoader.getSpecialNoticePageCount());

		} else {
			loadMoreValue = (int) loadMoreValueObject;

			session.setAttribute("loadMoreValue", loadMoreValue + specialNoticeLoader.getSpecialNoticePageCount());

		}

		try {

			String parameter = request.getParameter("key");

			if (parameter.equals("specialNoticeLoad") && specialNoticeLoader
					.getSpecialNoticePageList(loadMoreValue + specialNoticeLoader.getSpecialNoticePageCount())) {

				return specialNoticeLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	@RequestMapping(value = "/restRequest/specialSingleNoticeLoad", method = { RequestMethod.POST })
	public @ResponseBody SpecialNoticeLoader specialSingleNoticeLoad(HttpServletRequest request) {

		SpecialNoticeLoader specialNoticeLoader = new SpecialNoticeLoader();

		try {

			String parameter = request.getParameter("specialNoticeClick");

			if (parameter != null && specialNoticeLoader.getSingleSpecialNotice(parameter)) {

				return specialNoticeLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	@RequestMapping(value = "/restRequest/specialSingleNoticeLoadMainPage", method = { RequestMethod.POST })
	public @ResponseBody SpecialNoticeLoader specialSingleNoticeLoadMainPage(HttpServletRequest request) {

		SpecialNoticeLoader specialNoticeLoader = new SpecialNoticeLoader();

		try {

			String parameter = request.getParameter("key2");

			if (parameter != null && specialNoticeLoader.getHomePageList()) {

				return specialNoticeLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	// News
	@RequestMapping(value = "/restRequest/newsLoad", method = { RequestMethod.POST })
	public @ResponseBody NewsLoader newsLoad(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Object loadMoreValueObject = session.getAttribute("loadMoreValueNews");
		NewsLoader newsLoader = new NewsLoader();
		String parameter2 = request.getParameter("key2");
		int loadMoreValue = 0;
		if (loadMoreValueObject == null || parameter2 == null) {
			loadMoreValue = 0;
			session.setAttribute("loadMoreValueNews", newsLoader.getNewsPageCount());

		} else {
			loadMoreValue = (int) loadMoreValueObject;

			session.setAttribute("loadMoreValueNews", loadMoreValue + newsLoader.getNewsPageCount());

		}

		try {

			String parameter = request.getParameter("key");

			if (parameter.equals("newsLoad")
					&& newsLoader.getNewsPageList(loadMoreValue + newsLoader.getNewsPageCount())) {

				return newsLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	@RequestMapping(value = "/restRequest/SingleNewsLoad", method = { RequestMethod.POST })
	public @ResponseBody NewsLoader singleNewsLoad(HttpServletRequest request) {

		NewsLoader specialNoticeLoader = new NewsLoader();

		try {

			String parameter = request.getParameter("newsClick");

			if (parameter != null && specialNoticeLoader.getSingleNews(parameter)) {

				return specialNoticeLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	@RequestMapping(value = "/restRequest/SingleNewsLoadMainPage", method = { RequestMethod.POST })
	public @ResponseBody NewsLoader singleNewsLoadMainPage(HttpServletRequest request) {

		NewsLoader specialNoticeLoader = new NewsLoader();

		try {

			String parameter = request.getParameter("key2");

			if (parameter != null && specialNoticeLoader.getHomePageList()) {

				return specialNoticeLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}
	// RND

	@RequestMapping(value = "/restRequest/rndLoad", method = { RequestMethod.POST })
	public @ResponseBody ResearchAndDevelopmentLoader rndLoad(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Object loadMoreValueObject = session.getAttribute("loadMoreValueRND");
		ResearchAndDevelopmentLoader rndLoader = new ResearchAndDevelopmentLoader();
		String parameter2 = request.getParameter("key2");
		int loadMoreValue = 0;
		if (loadMoreValueObject == null || parameter2 == null) {
			loadMoreValue = 0;
			session.setAttribute("loadMoreValueRND", rndLoader.getResearchAndDevelopmentPageCount());

		} else {
			loadMoreValue = (int) loadMoreValueObject;

			session.setAttribute("loadMoreValueRND", loadMoreValue + rndLoader.getResearchAndDevelopmentPageCount());

		}

		try {

			String parameter = request.getParameter("key");

			if (parameter.equals("rndLoad") && rndLoader.getResearchAndDevelopmentPageList(
					loadMoreValue + rndLoader.getResearchAndDevelopmentPageCount())) {

				return rndLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	@RequestMapping(value = "/restRequest/SinglerndLoad", method = { RequestMethod.POST })
	public @ResponseBody ResearchAndDevelopmentLoader singleRNDLoad(HttpServletRequest request) {

		ResearchAndDevelopmentLoader specialrndLoader = new ResearchAndDevelopmentLoader();

		try {

			String parameter = request.getParameter("rndClick");

			if (parameter != null && specialrndLoader.getSingleResearchAndDevelopment(parameter)) {

				return specialrndLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	// Contact US
	@RequestMapping(value = "/restRequest/contactus", method = { RequestMethod.POST })
	public @ResponseBody Message contactUs(HttpServletRequest request) {

		return new EmailHandler().contactUs(request);

	}

	// Staff

	@RequestMapping(value = "/restRequest/staffLoad", method = { RequestMethod.POST })
	public @ResponseBody StaffLoader staffLoad(HttpServletRequest request) {

		StaffLoader staffLoader = new StaffLoader();
		try {
			String parameter = request.getParameter("key");

			if (parameter.equals("rndLoad") && staffLoader.getPageListValues()) {

				return staffLoader;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

	@RequestMapping(value = "/restRequest/SingleStaffLoad", method = { RequestMethod.POST })
	public @ResponseBody StaffLoader singleStaffLoad(HttpServletRequest request) {

		StaffLoader lecturer = new StaffLoader();

		try {

			String parameter = request.getParameter("staffClick");

			if (parameter != null && lecturer.getSingleLecturer(parameter)) {

				return lecturer;

			} else {

				return null;

			}

		} catch (Exception e) {

			return null;

		}

	}

}
