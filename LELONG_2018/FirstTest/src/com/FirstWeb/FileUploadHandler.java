package com.FirstWeb;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/FileUploadHandler")
public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String saveFile="C:/Users/LONG/LELONG_2018/FirstTest/Ref";
	private static final String saveFile="C:\\Users\\LONG\\LELONG_2018\\FirstTest\\WebContent";
	
	private static String NameFileUpload;
	public static String getNameFileUpload() {
		return NameFileUpload;
	}
	private void setNameFileUpload(String s) {
		NameFileUpload=s;
	}

	
	public static String getsaveFile() {
		return FileUploadHandler.saveFile;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String file_name = null;
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		 if (!isMultipartContent) {
		 return;
		 }
		 FileItemFactory factory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 try {
		 List < FileItem > fields = upload.parseRequest(request);
		 Iterator < FileItem > it = fields.iterator();
		 if (!it.hasNext()) {
		 return;
		 }
		 while (it.hasNext()) {
			 FileItem fileItem = it.next();
			 boolean isFormField = fileItem.isFormField();
			 if (isFormField) {
				 if (file_name == null) {
					 if (fileItem.getFieldName().equals("file_name")) {
						 file_name = fileItem.getString();
					 }
				 }
			 } else {
				 if (fileItem.getSize() > 0) {
					 //System.out.println(fileItem.getName()+"   "+fileItem.getFieldName());
					 //fileItem.write(new File("C:\\Users\\LONG" /*fileItem.getName()*/));
					 String nomFichier=FilenameUtils.getName(fileItem.getName());
					 setNameFileUpload(nomFichier);
					 File f =checkExits(nomFichier);
					 fileItem.write(f);
					 //this.getServletContext().getRequestDispatcher("/"+FileUploadHandler.getsaveFile()+"").forward(request, response);
					 //this.getServletContext().getRequestDispatcher("/"+nomFichier).forward(request, response);
					 
					 
					 
					
				 }
			 }
		 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 out.println("<script type='text/javascript'>");
			 out.println("window.location.href='index.jsp?filename="+file_name+"'");
			 out.println("</script>");
			 out.close();
		 }
		
	}
	private File checkExits(String fileName) {
		File f =new File(saveFile+"/"+fileName);
		
		//System.out.println(fileName);
		/*if (f.exists()) {
			StringBuffer sb = new StringBuffer(fileName);
			sb.insert(sb.lastIndexOf("."), "-"+new Date().getTime());
			System.out.println(sb);
			f =new File(saveFile+"/"+sb.toString());
		}*/
		return f;
	}

}
