package com.FirstWeb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@ManagedBean
@ViewScoped

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Part file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Action_file.jsp").forward(request, response);
		//this.upload();
		
		
		
		
		
		/*String f2 = request.getParameter("textinput");

		// File f = (File) request.getAttribute("guru_file");
		if (f2 != null)
			System.out.println( f2);
		else
			System.out.println("bla");*/

	}
	public void upload()throws IOException{
		Scanner sc=new Scanner(this.file.getInputStream());
		String fileContent=sc.useDelimiter("\\A").next();
		sc.close();
		Files.write(Paths.get("C:\\Users\\LONG"+file.getSubmittedFileName()),fileContent.getBytes(), StandardOpenOption.CREATE);
	}
	public Part getFile() {
		return this.file;
	}
	public void setfile(Part f) {
		this.file=f;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		this.getServletContext().getRequestDispatcher("/WEB-INF/Action_file.jsp").forward(request, response);
		// TODO Auto-generated method stub
		
	
		
	}

}
