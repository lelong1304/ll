package com.FirstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpFile
 */
@WebServlet("/UpFile")
public class UpFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet called");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                        String name = new File(item.getName()).getName();
	                        System.out.println("doGet called");
	                        item.write( new File("C:\\Users" + File.separator + name));
	                    }
	                }
	               //File uploaded successfully
	               request.setAttribute("gurumessage", "File Uploaded Successfully");
	            } catch (Exception ex) {
	               request.setAttribute("gurumessage", "File Upload Failed due to " + ex);
	            }         		
	        }else{
	
	            request.setAttribute("gurumessage","No File found");
}
	        request.getRequestDispatcher("/Result.jsp").forward(request, response);
	}

}
