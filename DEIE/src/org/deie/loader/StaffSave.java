package org.deie.loader;

import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.deie.model.Lecturer;
import org.deie.model.Message;
import org.deie.model.News;
import org.deie.model.ResearchAndDevelopment;
import org.deie.model.SpecialNotice;
import org.kadupitiya.dbhandler.DBConnectionManager;

public class StaffSave {

	private final String UPLOAD_DIRECTORY_RND = "assets/images/staff";

	private Lecturer current;

	private String index;

	public void RADevelopmentSave() {

	}

	public Lecturer getCurrent() {
		return current;
	}

	public void setCurrent(Lecturer current) {
		this.current = current;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Message addStaff(HttpServletRequest request) {
		String rnID = "";

		boolean isHead = false;

		int imageCount = 0;
		Message message = new Message();
		current = new Lecturer();

		// constructs the directory path to store upload file
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_RND;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		ArrayList<String> list = new ArrayList<>();

		// process only if its multipart content
		if (isMultipart) {

			int supervisor = 0, coSupervisor = 0;

			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// Parse the request
				List<FileItem> multiparts = upload.parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						imageCount++;
						String name = "";
						// String name = new File(item.getName()).getName();

						if (imageCount == 1) {
							name = index + ".jpg";
						} else {
							name = index + imageCount + ".jpg";
						}

						item.write(new File(uploadPath + File.separator + name));

						FileReader fr = new FileReader(uploadPath + File.separator + name);
						int chr_dat = fr.read();
						String temp = "";
						while (chr_dat != -1) // -1 is the value of the null
						{

							char ch = (char) chr_dat; // conert the int value
														// into char
														// by casting
							if (ch == '\n') {
								list.add(temp);
								// System.out.print(temp);
								temp = "";
							} else {
								temp += ch;
							}
							// System.out.print(ch); // print the text
							chr_dat = fr.read();
						}
						fr.close(); // should close the stream

						// String postListStr = JSON_POJO.pojoToJson(list);
						// out.write(MSG.getJSON_DATA_MSG(true, postListStr));
					} else {

						if (item.getFieldName().equals("staffName")) {
							current.setName(item.getString());
						} else if (item.getFieldName().equals("designation")) {
							current.setDesignation(item.getString());
						} else if (item.getFieldName().equals("acadamicQualif")) {
							current.setAcademicQulifications(item.getString());
						} else if (item.getFieldName().equals("professionalQualif")) {
							current.setProfessionalQualifications(item.getString());
						} else if (item.getFieldName().equals("email")) {
							current.setEmail(item.getString());
						} else if (item.getFieldName().equals("telephone")) {
							current.setTelephone(item.getString());
						} else if (item.getFieldName().equals("linkedin")) {
							current.setLinkedin(item.getString());
						} else if (item.getFieldName().equals("facebook")) {
							current.setFacebook(item.getString());
						} else if (item.getFieldName().equals("googlePlus")) {
							current.setGooglePlus(item.getString());
						} else if (item.getFieldName().equals("description")) {
							current.setDescription(item.getString());
						} else if (item.getFieldName().equals("moduleTought")) {
							current.setModulesTought(item.getString());
						} else if (item.getFieldName().equals("areaInterest")) {
							current.setAreaOfInterest(item.getString());
						} else if (item.getFieldName().equals("publication")) {
							current.setPublications(item.getString());
						} else if (item.getFieldName().equals("isHead")) {

							String val = item.getString();

							if (val.equalsIgnoreCase("ON")) {
								isHead = true;
								current.setIshead(1);
							}

						} else if (item.getFieldName().equals("staffPos")) {

							String sOrder = item.getString();
							int sorderNum = 0;

							try {
								sorderNum = Integer.parseInt(sOrder);

							} catch (Exception e) {

								sorderNum = 1;
							}

							current.setSortOrder(sorderNum);

						} else if (item.getFieldName().equals("staffNumber")) {
							rnID = item.getString();
							current.setLecturerId(Integer.parseInt(rnID));
							current.setImageName(item.getString() + ".jpg");
							index = rnID;
						}

					}
				}

				if (!isHead) {

					current.setIshead(0);
				} else {

					String statement3 = "UPDATE staff SET ishead='0'";

					DBConnectionManager.updateDatabase(statement3);
				}

				String statement2 = "UPDATE staff SET sortOrder = sortOrder + '1' where sortOrder > '"
						+ (current.getSortOrder() - 1) + "'";

				DBConnectionManager.updateDatabase(statement2);

				String statement1 = "INSERT INTO staff (`lecturerId`, `name`, `designation`, `academicQulifications`, `email`, `telephone`, `description`, `areaOfInterest`, `professionalQualifications`, `modulesTought`, `publications`, `ishead`, `imageName`, `isDisable`, `sortOrder`, `linkedin`, `googlePlus`, `facebook`) VALUES ('"
						+ current.getLecturerId() + "','" + current.getName() + "','" + current.getDesignation() + "','"
						+ current.getAcademicQulifications() + "','" + current.getEmail() + "','"
						+ current.getTelephone() + "','" + current.getDescription() + "','"
						+ current.getAreaOfInterest() + "','" + current.getProfessionalQualifications() + "','"
						+ current.getModulesTought() + "','" + current.getPublications() + "','" + current.getIshead()
						+ "','" + current.getImageName() + "','" + current.getIsDisable() + "','"
						+ current.getSortOrder() + "','" + current.getLinkedin() + "','" + current.getGooglePlus()
						+ "','" + current.getFacebook() + "')";
				DBConnectionManager.updateDatabase(statement1);

				message.setStatus(true);
				message.setMessage("successfully done");

			} catch (Exception e) {
				System.out.println("File upload failed or database error");
				message.setStatus(false);
				message.setMessage("File upload failed or database error");
			}
		}

		return message;
	}

	public Message getStaffIDList(HttpServletRequest request) {

		java.sql.ResultSet resultset1;

		Message message = new Message();

		ArrayList<Integer> idList = new ArrayList<Integer>();

		try {

			String statement = "SELECT DISTINCT lecturerId FROM staff ORDER BY lecturerId";

			resultset1 = DBConnectionManager.getResult(statement);

			while (resultset1.next()) {

				idList.add(resultset1.getInt("lecturerId"));

			}

			if (idList.size() > 0) {

				message.setData(idList);
				message.setStatus(true);
				message.setMessage("Data found");

			} else {

				message.setData(null);
				message.setStatus(false);
				message.setMessage("Data not found");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.setStatus(false);
			message.setMessage("Database error");
		}

		return message;

	}

	public Message getStaffID(HttpServletRequest request) {

		java.sql.ResultSet resultset1;

		Message message = new Message();

		try {

			String statement = "SELECT MAX(lecturerId)+1 as lecturerId FROM staff";

			resultset1 = DBConnectionManager.getResult(statement);

			if (resultset1.next()) {

				message.setData(resultset1.getInt("lecturerId"));

			} else {

				message.setData(1);

			}
			message.setStatus(true);
			message.setMessage("data found");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.setStatus(false);
			message.setMessage("Data Base Error");

		}

		return message;

	}

	public Message setDisableStaff(String index) {

		Message message = new Message();
		java.sql.ResultSet resultset1, resultset2;

		try {

			int value = 0;

			String statement2 = "SELECT * FROM staff WHERE lecturerId='" + index + "'";

			resultset2 = DBConnectionManager.getResult(statement2);

			while (resultset2.next()) {

				int int1 = resultset2.getInt("isDisable");

				if (int1 == 0) {

					value = 1;
					message.setMessage("Disable sucess");
				} else {

					value = 0;
					message.setMessage("Enable sucess");
				}

			}

			String statement = "UPDATE staff SET isDisable='" + value + "' WHERE lecturerId='" + index + "'";
			int updateDatabase = DBConnectionManager.updateDatabase(statement);

			if (updateDatabase > 0) {

				message.setStatus(true);

			} else {
				message.setStatus(false);
				message.setMessage("Disable was not a sucess");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			message.setStatus(false);
			message.setMessage("Database Error");
		}

		return message;

	}

	public Message updateStaff(HttpServletRequest request) {
		String rnID = "";

		boolean isHead = false;

		int imageCount = 0;
		String val = "";
		Message message = new Message();
		current = new Lecturer();

		// constructs the directory path to store upload file
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_RND;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		ArrayList<String> list = new ArrayList<>();

		// process only if its multipart content
		if (isMultipart) {

			int supervisor = 0, coSupervisor = 0;

			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// Parse the request
				List<FileItem> multiparts = upload.parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						imageCount++;
						String name = "";
						// String name = new File(item.getName()).getName();

						if (imageCount == 1) {
							name = index + ".jpg";
						} else {
							name = index + imageCount + ".jpg";
						}

						item.write(new File(uploadPath + File.separator + name));

						FileReader fr = new FileReader(uploadPath + File.separator + name);
						int chr_dat = fr.read();
						String temp = "";
						while (chr_dat != -1) // -1 is the value of the null
						{

							char ch = (char) chr_dat; // conert the int value
														// into char
														// by casting
							if (ch == '\n') {
								list.add(temp);
								// System.out.print(temp);
								temp = "";
							} else {
								temp += ch;
							}
							// System.out.print(ch); // print the text
							chr_dat = fr.read();
						}
						fr.close(); // should close the stream

						// String postListStr = JSON_POJO.pojoToJson(list);
						// out.write(MSG.getJSON_DATA_MSG(true, postListStr));
					} else {

						if (item.getFieldName().equals("staffName")) {
							current.setName(item.getString());
						} else if (item.getFieldName().equals("designation")) {
							current.setDesignation(item.getString());
						} else if (item.getFieldName().equals("acadamicQualif")) {
							current.setAcademicQulifications(item.getString());
						} else if (item.getFieldName().equals("professionalQualif")) {
							current.setProfessionalQualifications(item.getString());
						} else if (item.getFieldName().equals("email")) {
							current.setEmail(item.getString());
						} else if (item.getFieldName().equals("telephone")) {
							current.setTelephone(item.getString());
						} else if (item.getFieldName().equals("linkedin")) {
							current.setLinkedin(item.getString());
						} else if (item.getFieldName().equals("facebook")) {
							current.setFacebook(item.getString());
						} else if (item.getFieldName().equals("googlePlus")) {
							current.setGooglePlus(item.getString());
						} else if (item.getFieldName().equals("description")) {
							current.setDescription(item.getString());
						} else if (item.getFieldName().equals("moduleTought")) {
							current.setModulesTought(item.getString());
						} else if (item.getFieldName().equals("areaInterest")) {
							current.setAreaOfInterest(item.getString());
						} else if (item.getFieldName().equals("publication")) {
							current.setPublications(item.getString());
						} else if (item.getFieldName().equals("isHead")) {

							String val2 = item.getString();

							if (val2.equalsIgnoreCase("ON")) {
								isHead = true;
								current.setIshead(1);
							}

						} else if (item.getFieldName().equals("staffPos")) {

							String sOrder = item.getString();
							int sorderNum = 0;

							try {
								sorderNum = Integer.parseInt(sOrder);

							} catch (Exception e) {

								sorderNum = 1;
							}

							current.setSortOrder(sorderNum);

						} else if (item.getFieldName().equals("staffNumber")) {
							rnID = item.getString();
							current.setLecturerId(Integer.parseInt(rnID));
							current.setImageName(item.getString() + ".jpg");
							index = rnID;
						} else if (item.getFieldName().equals("searchnoticeActionType")) {

							val = item.getString();
						}

					}
				}

				if (val.equals("editButton")) {

					int max = 0, curr = 0, prev = 0;

					String statement5 = "SELECT sortOrder FROM staff WHERE lecturerId='" + current.getLecturerId()
							+ "'";

					ResultSet result5 = DBConnectionManager.getResult(statement5);

					while (result5.next()) {

						prev = result5.getInt("sortOrder");

					}

					String statement6 = "SELECT MAX(sortOrder) as sortOrder FROM staff";

					ResultSet result6 = DBConnectionManager.getResult(statement6);

					while (result6.next()) {

						max = result6.getInt("sortOrder");

					}

					curr = current.getSortOrder();

					if (curr >= max) {

						current.setSortOrder(max);

						String statement2 = "UPDATE staff SET sortOrder = sortOrder - '1' where sortOrder > '" + prev
								+ "'";

						DBConnectionManager.updateDatabase(statement2);

					} else if (curr < prev) {

						String statement2 = "UPDATE staff SET sortOrder = sortOrder + '1' where sortOrder > '"
								+ (curr - 1) + "' AND sortOrder <'" + prev + "'";

						DBConnectionManager.updateDatabase(statement2);

					} else if (curr > prev) {

						String statement2 = "UPDATE staff SET sortOrder = sortOrder - '1' where sortOrder < '"
								+ (curr + 1) + "' AND sortOrder >'" + prev + "'";

						DBConnectionManager.updateDatabase(statement2);

					}

					if (!isHead) {

						current.setIshead(0);
					} else {

						String statement3 = "UPDATE staff SET ishead='0'";

						DBConnectionManager.updateDatabase(statement3);
					}

					String statement1 = "UPDATE staff SET name='" + current.getName() + "' , designation='"
							+ current.getDesignation() + "', academicQulifications='"
							+ current.getAcademicQulifications() + "', email='" + current.getEmail() + "', telephone='"
							+ current.getTelephone() + "', description='" + current.getDescription()
							+ "', areaOfInterest='" + current.getAreaOfInterest() + "', professionalQualifications='"
							+ current.getProfessionalQualifications() + "', modulesTought='"
							+ current.getModulesTought() + "', publications='" + current.getPublications()
							+ "', ishead='" + current.getIshead() + "', imageName='" + current.getImageName()
							+ "', isDisable='" + current.getIsDisable() + "', sortOrder='" + current.getSortOrder()
							+ "', linkedin='" + current.getLinkedin() + "', googlePlus='" + current.getGooglePlus()
							+ "', facebook='" + current.getFacebook() + "'WHERE lecturerId='" + current.getLecturerId()
							+ "'";

					DBConnectionManager.updateDatabase(statement1);

					message.setStatus(true);
					message.setMessage("successfully done");

				}

			} catch (Exception e) {
				System.out.println("File upload failed or database error");
				message.setStatus(false);
				message.setMessage("File upload failed or database error");
			}
		} else {

			index = request.getParameter("StaffNumber");
			val = request.getParameter("searchnoticeActionType");

			if (val.equals("disableButton")) {

				message = (setDisableStaff(index));

			}

		}

		return message;
	}

}
