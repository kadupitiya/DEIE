package org.deie.controller;

import javax.servlet.http.HttpServletRequest;

import org.deie.loader.NewsSave;
import org.deie.loader.SpecialNoticeSave;
import org.deie.loader.StaffSave;
import org.deie.loader.RADevelopmentSave;
import org.deie.loader.UserAccountManager;
import org.deie.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class DashBoardController {

	// Special Notice methods
	@RequestMapping(value = "/restRequest/dashBoard/specialNoticeAdd", method = { RequestMethod.POST })
	public @ResponseBody Message specialNoticeLoad(HttpServletRequest request) {

		return new SpecialNoticeSave().addSP(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/getSpecialNoticeID", method = { RequestMethod.POST })
	public @ResponseBody Message getSpecialNoticeID(HttpServletRequest request) {

		return new SpecialNoticeSave().getSpecialNoticeID(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/getSpecialNoticeIDList", method = { RequestMethod.POST })
	public @ResponseBody Message getSpecialNoticeIDList(HttpServletRequest request) {

		return new SpecialNoticeSave().getSpecialNoticeIDList(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/updateSpecialNews", method = { RequestMethod.POST })
	public @ResponseBody Message updateSpecialNews(HttpServletRequest request) {

		return new SpecialNoticeSave().updateSpecialNews(request);

	}

	// News Methods

	@RequestMapping(value = "/restRequest/dashBoard/newsAdd", method = { RequestMethod.POST })
	public @ResponseBody Message newsLoad(HttpServletRequest request) {

		return new NewsSave().addNews(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/getNewsID", method = { RequestMethod.POST })
	public @ResponseBody Message getNewsID(HttpServletRequest request) {

		return new NewsSave().getNewsID(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/getNewsIDList", method = { RequestMethod.POST })
	public @ResponseBody Message getNewsIDList(HttpServletRequest request) {

		return new NewsSave().getNewsIDList(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/updateNews", method = { RequestMethod.POST })
	public @ResponseBody Message updateNews(HttpServletRequest request) {

		return new NewsSave().updateNews(request);

	}

	// R & D methods
	@RequestMapping(value = "/restRequest/dashBoard/rndAdd", method = { RequestMethod.POST })
	public @ResponseBody Message rndLoad(HttpServletRequest request) {

		return new RADevelopmentSave().addRND(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/getRnDID", method = { RequestMethod.POST })
	public @ResponseBody Message getRnDID(HttpServletRequest request) {

		return new RADevelopmentSave().getRnDID(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/getRnDIDList", method = { RequestMethod.POST })
	public @ResponseBody Message getRnDIDList(HttpServletRequest request) {

		return new RADevelopmentSave().getRnDIDList(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/updateRnD", method = { RequestMethod.POST })
	public @ResponseBody Message updateRnD(HttpServletRequest request) {

		return new RADevelopmentSave().updateRnD(request);

	}

	// Settings Methods

	@RequestMapping(value = "/restRequest/dashBoard/passwordChange", method = { RequestMethod.POST })
	public @ResponseBody Message passwordChange(HttpServletRequest request) {

		return new UserAccountManager().changePassword(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/login", method = { RequestMethod.POST })
	public @ResponseBody Message login(HttpServletRequest request) {

		return new UserAccountManager().login(request);

	}

	@RequestMapping(value = "/restRequest/dashBoard/logout", method = { RequestMethod.POST })
	public @ResponseBody Message logout(HttpServletRequest request) {

		return new UserAccountManager().logout(request);

	}
	// Staff methods
		@RequestMapping(value = "/restRequest/dashBoard/staffAdd", method = { RequestMethod.POST })
		public @ResponseBody Message staffAdd(HttpServletRequest request) {

			return new StaffSave().addStaff(request);

		}

		@RequestMapping(value = "/restRequest/dashBoard/getStaffID", method = { RequestMethod.POST })
		public @ResponseBody Message getStaffID(HttpServletRequest request) {

			return new StaffSave().getStaffID(request);

		}

		@RequestMapping(value = "/restRequest/dashBoard/getStaffIDList", method = { RequestMethod.POST })
		public @ResponseBody Message getStaffIDList(HttpServletRequest request) {

			return new StaffSave().getStaffIDList(request);

		}

		@RequestMapping(value = "/restRequest/dashBoard/updateStaff", method = { RequestMethod.POST })
		public @ResponseBody Message updateStaff(HttpServletRequest request) {

			return new StaffSave().updateStaff(request);

		}

	

}
