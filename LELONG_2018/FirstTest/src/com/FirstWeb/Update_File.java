package com.FirstWeb;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
//import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;


@WebServlet("/Update_File")
public class Update_File extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String saveFile="C:/Users/LONG/Upload";
  
    public Update_File() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			boolean isMultipart=ServletFileUpload.isMultipartContent(request);
			if (!isMultipart) {
				
			}
			else {
				FileItemFactory factory=new DiskFileItemFactory();
				ServletFileUpload upload =new ServletFileUpload(factory);
				List items = null;
				try {
					items=upload.parseRequest(request);
				}
				catch (Exception e) {
			
				}
				Iterator itr = items.iterator();
				while(itr.hasNext()) {
					FileItem item=(FileItem) itr.next();
					
					if (item.isFormField()) {
						
					}
					else {
						String itemName = item.getName();
						if (itemName==null || itemName.equals("")){
							continue;
						}
						String fileName=FilenameUtils.getName(itemName);
						File f = checkExits(fileName);
						item.write(f);
					}
				}
				
				
			}
		}
		catch (Exception e) {
		}
		finally {
			out.close();
		}
	}
	private File checkExits(String fileName) {
		File f =new File(saveFile+"/"+fileName);
		
		System.out.println(fileName);
		/*if (f.exists()) {
			StringBuffer sb = new StringBuffer(fileName);
			sb.insert(sb.lastIndexOf("."), "-"+new Date().getTime());
			System.out.println(sb);
			f =new File(saveFile+"/"+sb.toString());
		}*/
		return f;
	}

}
