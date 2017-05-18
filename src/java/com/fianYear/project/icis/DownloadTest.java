/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns = {"/DownloadTest"})
public class DownloadTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String fileName="Parallel.pdf";
        String filePath="C:\\xampp\\tomcat\\";
        response.setContentType("APPLICATION/PDF");
        response.setHeader("Content-Disposition", "inline;fileName=\""+fileName+"\"");
        FileInputStream inputStream=new FileInputStream(filePath+fileName);
        
        int i;
        while((i=inputStream.read()) !=-1)
            out.write(i);
            inputStream.close();
            out.close();
            
    }

}
