package com.FirstWeb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
//@WebServlet("/Ref/*")
@WebServlet(urlPatterns = { "/Ref/*" })
public class Ref extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFile=FileUploadHandler.getsaveFile();
	String nom;
       
  
    public Ref() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/csv");
		
		StringBuffer url=request.getRequestURL();
		System.out.println(url);
		
		char c='/';
		String tmp=url.toString();
		int index=tmp.lastIndexOf(c);
		url.delete(0,index+1);
		
		String csvFile=this.pathFile+"\\"+url.toString()+".csv";
		
		
		BufferedReader br = null;
        String line = null;
      
        
       try {

            br = new BufferedReader(new FileReader(csvFile));
            for (line = br.readLine(); line != null; line = br.readLine()) {
            	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
