package com.FirstWeb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFile=FileUploadHandler.getsaveFile();
	String nom;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
		//response.getWriter().append("<html><body><h1> my header</h1>").append(request.getContextPath()).append("</body></html>");
				// this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		
		response.setContentType("text/csv");
		String[] parts=FileUploadHandler.getNameFileUpload().split("."); 
		
		
		System.out.println(request.getRequestURL());
		//String csvFile="C:\\REF_POINT_GEOGRAPHIQUE.csv";
		String csvFile=this.pathFile+"\\"+FileUploadHandler.getNameFileUpload();
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

               
             
            	response.getWriter().println(line);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		/*response.setContentType("text/csv");
		String[] parts=FileUploadHandler.getNameFileUpload().split("."); 
		nom=parts[0];
		
		
		System.out.println(request.getRequestURL());
		//String csvFile="C:\\REF_POINT_GEOGRAPHIQUE.csv";
		String csvFile=this.pathFile+"\\"+FileUploadHandler.getNameFileUpload();
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

               
             
            	response.getWriter().println(line);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		*/
	}

}
