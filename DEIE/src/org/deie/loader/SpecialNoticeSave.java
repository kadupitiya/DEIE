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
import org.deie.model.Message;
import org.deie.model.News;
import org.deie.model.SpecialNotice;
import org.kadupitiya.dbhandler.DBConnectionManager;

public class SpecialNoticeSave {

	private final String UPLOAD_DIRECTORY_SP = "assets/images/specialNotice";

	private SpecialNotice current;

	private String index;

	public SpecialNoticeSave() {

	}

	public SpecialNotice getCurrent() {
		return current;
	}

	public void setCurrent(SpecialNotice current) {
		this.current = current;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Message addSP(HttpServletRequest request) {
		String title = "", description = "", spID = "";
		int imageCount=0;
		Message message = new Message();
		current = new SpecialNotice();

		// constructs the directory path to store upload file
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_SP;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		ArrayList<String> list = new ArrayList<>();

		// process only if its multipart content
		if (isMultipart) {
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
						String name="";
						// String name = new File(item.getName()).getName();

						if(imageCount==1){
							name = index + ".jpg";	
						}else{
							name = index+imageCount + ".jpg";
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

						if (item.getFieldName().equals("noticeTitle")) {
							title = item.getString();
							current.setTitle(title);
						} else if (item.getFieldName().equals("noticeDes")) {
							description = item.getString();
							current.setDescription(description);
						} else if (item.getFieldName().equals("noticeNumber")) {
							spID = item.getString();
							current.setSpecialNoticeId(Integer.parseInt(spID));
							index = spID;
						}

						
						
						

					}
				}

				String statement1 = "INSERT INTO specialnotice (`newsId`, `title`, `description`, `imageName`, `imageCount`) VALUES ('"
						+ Integer.parseInt(spID) + "','" + title + "','" + description + "','" + spID + ".jpg','" + imageCount + "')";
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

	public Message getSpecialNoticeID(HttpServletRequest request) {

		java.sql.ResultSet resultset1;

		Message message = new Message();

		try {

			String statement = "SELECT MAX(newsId)+1 as newsId FROM specialnotice";

			resultset1 = DBConnectionManager.getResult(statement);

			if (resultset1.next()) {

				message.setData(resultset1.getInt("newsId"));

			}else{
				
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
	
	public Message getSpecialNoticeIDList(HttpServletRequest request) {

		java.sql.ResultSet resultset1;

		Message message = new Message();

		ArrayList<Integer> idList = new ArrayList<Integer>();
		
		try {
	
			String statement = "SELECT DISTINCT newsId FROM specialnotice ORDER BY newsId";

			resultset1 = DBConnectionManager.getResult(statement);

			while (resultset1.next()) {

				idList.add(resultset1.getInt("newsId"));
				
			}
			
			if (idList.size()>0) {

				message.setData(idList);
				message.setStatus(true);
				message.setMessage("Data found");

			}else{
				
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
	
	public Message setDisableSpecialNews(String index) {

		Message message = new Message();
		java.sql.ResultSet resultset1 ,resultset2;

		try {
			
			int value=0;

			String statement2 = "SELECT * FROM specialnotice WHERE newsId='" + index + "'";

			resultset2 = DBConnectionManager.getResult(statement2);

			while (resultset2.next()) {

				int int1 = resultset2.getInt("isDisable");
				
				if(int1==0){
					
					value=1;
					message.setMessage("Disable sucess");
				}else{
					
					value=0;
					message.setMessage("Enable sucess");
				}
				
			}
			
			
			
			String statement = "UPDATE specialnotice SET isDisable='"
					+ value + "' WHERE newsId='" + index + "'";
			int updateDatabase = DBConnectionManager
					.updateDatabase(statement);

			

			if (updateDatabase >0) {

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
	
	public Message updateSpecialNews(HttpServletRequest request) {

		String title = "", description = "", spID = "";
		Message message = new Message();
		current = new SpecialNotice();

		// constructs the directory path to store upload file
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_SP;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		ArrayList<String> list = new ArrayList<>();
		int imageCount=0;
		String val="";
		
		// process only if its multipart content
		if (isMultipart) {
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
						String name="";
						// String name = new File(item.getName()).getName();

						if(imageCount==1){
							name = index + ".jpg";	
						}else{
							name = index+imageCount + ".jpg";
						}

						item.write(new File(uploadPath + File.separator + name ));

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

						if (item.getFieldName().equals("SnoticeTitle")) {
							title = item.getString();
							current.setTitle(title);
						} else if (item.getFieldName().equals("SnoticeDes")) {
							description = item.getString();
							current.setDescription(description);
						} else if (item.getFieldName().equals("SnoticeNumber")) {
							spID = item.getString();
							current.setSpecialNoticeId(Integer.parseInt(spID));
							index = spID;
						} else if(item.getFieldName().equals("searchnoticeActionType")){
							
							val=item.getString();
						}
	

					}
				}

				if(val.equals("editButton")){
					
					String statement1 = "UPDATE specialnotice SET title='"
							+ current.getTitle() + "',description='"
							+ current.getDescription() + "',imageCount='"
									+ imageCount + "' WHERE newsId='" + index + "'";
					DBConnectionManager.updateDatabase(statement1);

					message.setStatus(true);
					message.setMessage("successfully done");
					
				}
				

			} catch (Exception e) {
				
				message.setStatus(false);
				message.setMessage("File upload failed or database error");
			}
		}else{
			
			index = request.getParameter("noticeNumber");
			val = request.getParameter("searchnoticeActionType");
			
			
			if(val.equals("disableButton")){
			
				message = (setDisableSpecialNews(index));
				
			}
		
		}

		return message;
		
	}

}
