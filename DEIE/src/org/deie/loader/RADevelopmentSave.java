package org.deie.loader;

import java.io.File;
import java.io.FileReader;
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

public class RADevelopmentSave {

	private final String UPLOAD_DIRECTORY_RND = "assets/images/researchanddevelopment";

	private ResearchAndDevelopment current;

	private String index;

	public void RADevelopmentSave() {

	}

	public ResearchAndDevelopment getCurrent() {
		return current;
	}

	public void setCurrent(ResearchAndDevelopment current) {
		this.current = current;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Message addRND(HttpServletRequest request) {
		String rnID = "";

		String description;

		int imageCount = 0;
		Message message = new Message();
		current = new ResearchAndDevelopment();

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

						if (item.getFieldName().equals("R&DTitle")) {
							current.setTopic(item.getString());
						} else if (item.getFieldName().equals("R&DDes")) {
							current.setDescription(item.getString());
						} else if (item.getFieldName().equals("R&DAbstract")) {
							current.setAbstractDetails(item.getString());
						} else if (item.getFieldName().equals("R&DDate")) {
							current.setDate(item.getString());
						} else if (item.getFieldName().equals("R&DMemberNames")) {
							current.setMemberNames(item.getString());
						} else if (item.getFieldName().equals("R&DKeywords")) {
							current.setKeywords(item.getString());
						} else if (item.getFieldName().equals("R&DWebsiteLink")) {
							current.setWebsiteLink(item.getString());
						} else if (item.getFieldName().equals("R&DYouTubeLink")) {
							current.setYouTubeLink(item.getString());
						} else if (item.getFieldName().equals("R&DCoSupervisor")) {

							if (item.getString().equalsIgnoreCase("SELECT")) {

								coSupervisor = 0;

							} else {

								String[] cosplit = item.getString().split(" :: ");
								coSupervisor = Integer.parseInt(cosplit[cosplit.length - 1]);

							}

						} else if (item.getFieldName().equals("R&DSupervisor")) {

							if (item.getString().equalsIgnoreCase("SELECT")) {

								supervisor = 0;

							} else {

								String[] cosplit = item.getString().split(" :: ");

								supervisor = Integer.parseInt(cosplit[cosplit.length - 1]);
							}

						} else if (item.getFieldName().equals("R&DNumber")) {
							rnID = item.getString();
							current.setResearchId(Integer.parseInt(rnID));
							current.setImageName(item.getString() + ".jpg");
							index = rnID;
						}

					}
				}

				String statement1 = "INSERT INTO researchanddevelopment (`researchId`, `topic`, `imageName`, `youTubeLink`, `abstractDetails`, `websiteLink`, `keywords`, `memberNames`, `date`, `description`, `imageCount`) VALUES ('"
						+ current.getResearchId() + "','" + current.getTopic() + "','" + current.getImageName() + "','"
						+ current.getYouTubeLink() + "','" + current.getAbstractDetails() + "','"
						+ current.getWebsiteLink() + "','" + current.getKeywords() + "','" + current.getMemberNames()
						+ "','" + current.getDate() + "','" + current.getDescription() + "','" + imageCount + "')";
				DBConnectionManager.updateDatabase(statement1);

				String statement2 = "";

				if (supervisor == coSupervisor) {
					statement2 = "INSERT INTO assignedproject (`researchId`, `lecturerId` , `CoSupervisor`)  VALUES ('"
							+ current.getResearchId() + "','" + supervisor + "','0')";
				} else {

					statement2 = "INSERT INTO assignedproject (`researchId`, `lecturerId` , `CoSupervisor`)  VALUES ('"
							+ current.getResearchId() + "','" + supervisor + "','" + coSupervisor + "')";

				}
				DBConnectionManager.updateDatabase(statement2);
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

	public Message getRnDIDList(HttpServletRequest request) {

		java.sql.ResultSet resultset1;

		Message message = new Message();

		ArrayList<Integer> idList = new ArrayList<Integer>();

		try {

			String statement = "SELECT DISTINCT researchId FROM researchanddevelopment ORDER BY researchId";

			resultset1 = DBConnectionManager.getResult(statement);

			while (resultset1.next()) {

				idList.add(resultset1.getInt("researchId"));

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

	public Message getRnDID(HttpServletRequest request) {

		java.sql.ResultSet resultset1;

		Message message = new Message();

		try {

			String statement = "SELECT MAX(researchId)+1 as researchId FROM researchanddevelopment";

			resultset1 = DBConnectionManager.getResult(statement);

			if (resultset1.next()) {

				message.setData(resultset1.getInt("researchId"));

			} else {

				message.setData(1);

			}
			message.setData2(getLecturerList());
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

	public Object getLecturerList() {

		java.sql.ResultSet resultset1;

		try {

			String statement = "SELECT DISTINCT * FROM staff Where isDisable='0' ORDER BY sortOrder";

			resultset1 = DBConnectionManager.getResult(statement);

			List<Lecturer> lecList = new ArrayList<Lecturer>();

			while (resultset1.next()) {

				Lecturer lecturer = new Lecturer();
				lecturer.setLecturerId(resultset1.getInt("lecturerId"));
				lecturer.setName(resultset1.getString("name"));

				lecList.add(lecturer);
			}

			if (lecList.size() > 0) {

				return lecList;
			} else {

				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;

		}

	}

	public Message setDisableRnD(String index) {

		Message message = new Message();
		java.sql.ResultSet resultset1, resultset2;

		try {

			int value = 0;

			String statement2 = "SELECT * FROM researchanddevelopment WHERE researchId='" + index + "'";

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

			String statement = "UPDATE researchanddevelopment SET isDisable='" + value + "' WHERE researchId='" + index
					+ "'";
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

	public Message updateRnD(HttpServletRequest request) {

		String rnID = "";
		Message message = new Message();
		current = new ResearchAndDevelopment();

		// constructs the directory path to store upload file
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_RND;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		ArrayList<String> list = new ArrayList<>();
		int imageCount = 0;
		String val = "";

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

						// String name = new File(item.getName()).getName();

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

						if (item.getFieldName().equals("RnDTitle2")) {
							current.setTopic(item.getString());
						} else if (item.getFieldName().equals("RnDDes2")) {
							current.setDescription(item.getString());
						} else if (item.getFieldName().equals("RnDAbstract2")) {
							current.setAbstractDetails(item.getString());
						} else if (item.getFieldName().equals("RnDDate2")) {
							current.setDate(item.getString());
						} else if (item.getFieldName().equals("RnDMemberNames2")) {
							current.setMemberNames(item.getString());
						} else if (item.getFieldName().equals("RnDKeywords2")) {
							current.setKeywords(item.getString());
						} else if (item.getFieldName().equals("RnDWebsiteLink2")) {
							current.setWebsiteLink(item.getString());
						} else if (item.getFieldName().equals("RnDYouTubeLink2")) {
							current.setYouTubeLink(item.getString());
						} else if (item.getFieldName().equals("R&DCoSupervisor")) {

							if (item.getString().equalsIgnoreCase("SELECT")) {

								coSupervisor = 0;

							} else {

								String[] cosplit = item.getString().split(" :: ");
								coSupervisor = Integer.parseInt(cosplit[cosplit.length - 1]);

							}

						} else if (item.getFieldName().equals("R&DSupervisor")) {

							if (item.getString().equalsIgnoreCase("SELECT")) {

								supervisor = 0;

							} else {

								String[] cosplit = item.getString().split(" :: ");

								supervisor = Integer.parseInt(cosplit[cosplit.length - 1]);
							}

						} else if (item.getFieldName().equals("rndNumber2")) {
							rnID = item.getString();
							current.setResearchId(Integer.parseInt(rnID));
							current.setImageName(item.getString() + ".jpg");
							index = rnID;
						} else if (item.getFieldName().equals("searchnoticeActionType")) {

							val = item.getString();
						}

					}
				}

				if (val.equals("editButton")) {

					String statement1 = "UPDATE researchanddevelopment SET topic='" + current.getTopic()
							+ "',imageName='" + current.getImageName() + "',imageCount='" + imageCount
							+ "',youTubeLink='" + current.getYouTubeLink() + "',abstractDetails='"
							+ current.getAbstractDetails() + "',websiteLink='" + current.getWebsiteLink()
							+ "',keywords='" + current.getKeywords() + "',memberNames='" + current.getMemberNames()
							+ "',date='" + current.getDate() + "',description='" + current.getDescription()
							+ "'  WHERE researchId='" + index + "'";
					DBConnectionManager.updateDatabase(statement1);

					String statement2 = "";

					if (supervisor == coSupervisor) {
						statement2 = "UPDATE assignedproject SET lecturerId='" + supervisor + "' ,CoSupervisor='" + "0"
								+ "'WHERE researchId='" + current.getResearchId() + "'";
					} else {

						statement2 = "UPDATE assignedproject SET lecturerId='" + supervisor + "' ,CoSupervisor='"
								+ coSupervisor + "'WHERE researchId='" + current.getResearchId() + "'";

					}
					DBConnectionManager.updateDatabase(statement2);

					message.setStatus(true);
					message.setMessage("successfully done");

				}

			} catch (Exception e) {

				message.setStatus(false);
				message.setMessage("File upload failed or database error");
			}
		} else {

			index = request.getParameter("rndNumber1");
			val = request.getParameter("searchnoticeActionType");

			if (val.equals("disableButton")) {

				message = (setDisableRnD(index));

			}

		}

		return message;

	}

}
