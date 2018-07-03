package org.deie.loader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.deie.model.Message;
import org.kadupitiya.dbhandler.DBConnectionManager;

public class UserAccountManager {

	private String userName;
	private String oldPassword;
	private String newPassword;

	public UserAccountManager() {

	}

	public Message changePassword(HttpServletRequest request) {
		Message message = new Message();

		userName = request.getParameter("userName");
		oldPassword = Integer.toString(request.getParameter("oldpassword").hashCode());
		newPassword = Integer.toString(request.getParameter("newpassword").hashCode());

		String existingPass = "";

		String statement = "SELECT * FROM user where userName='" + userName + "'";

		java.sql.ResultSet resultset1;

		try {

			resultset1 = DBConnectionManager.getResult(statement);

			if (resultset1.next()) {

				existingPass = resultset1.getString("passwordHashed");

				if (newPassword.length() > 5) {

					if (existingPass.equals(oldPassword)) {

						String statement2 = "UPDATE user SET passwordHashed='" + newPassword + "' WHERE userName='"
								+ userName + "'";
						int updateDatabase = DBConnectionManager.updateDatabase(statement2);

						message.setCondition(true);
						message.setMessage("Password Updated Successfully..");

					} else {
						message.setCondition(false);
						message.setMessage("Old Password is wrong ..");

					}

				} else {
					message.setCondition(false);
					message.setMessage("Password must have atleast 5 characters..");

				}
			} else {

				message.setCondition(false);
				message.setMessage("User name is wrong..");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			message.setCondition(false);
			message.setMessage("Database Error..");

		}

		return message;
	}

	public Message login(HttpServletRequest request) {
		Message message = new Message();

		userName = request.getParameter("inputName");
		oldPassword = Integer.toString(request.getParameter("inputPassword").hashCode());

		String existingPass = "";

		String statement = "SELECT * FROM user where userName='" + userName + "'";

		java.sql.ResultSet resultset1;

		try {

			resultset1 = DBConnectionManager.getResult(statement);

			if (resultset1.next()) {

				existingPass = resultset1.getString("passwordHashed");

				if (existingPass.equals(oldPassword)) {
					message.setCondition(true);
					HttpSession session1 = request.getSession();
					session1.setAttribute("userName", userName);
				} else {

					HttpSession session1 = request.getSession();
					session1.invalidate();
					message.setCondition(false);
					message.setMessage("Wrong Password..");
				}

			} else {

				message.setCondition(false);
				message.setMessage("User name is wrong..");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			message.setCondition(false);
			message.setMessage("Database Error..");

		}

		return message;

	}

	public Message logout(HttpServletRequest request) {

		Message message = new Message();
		HttpSession session1 = request.getSession();
		String userName = (String) session1.getAttribute("userName");

		if (userName != null) {

			session1.setAttribute("userName", null);
			session1.invalidate();
			message.setCondition(true);
			message.setMessage("Logout is Successfull..");

		} else {
			session1.invalidate();
			message.setCondition(false);
			message.setMessage("Still Not Logged in..");

		}

		return message;

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
