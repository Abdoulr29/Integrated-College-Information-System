/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns={"/TestDbFileUpload"})
@MultipartConfig(maxFileSize=16177215)
public class TestDbFileUpload extends HttpServlet {
    private static final int BUFFER_SIZE=4096;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getParameter("user");
        InputStream inputStream=null;
        Part filePart=request.getPart("myImage");
        if(filePart !=null){
        System.out.println(filePart.getName());
        System.out.println(filePart.getSize());
        System.out.println(filePart.getContentType());
        inputStream=filePart.getInputStream();
        }
        String message=null;
        TestDbFiles fileUpload=new TestDbFiles();
        fileUpload.setUsername(user);
        if(inputStream !=null){
            
        fileUpload.setMyImage(inputStream.);
        
        }
        TestDbFiles.createMyTest(fileUpload);
    }
   
    
}
