/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns = {"/DownloadTesting"})
public class DownloadTesting extends HttpServlet {

   // private static final int BUFFER_SIZE = 4096;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int uploadId = 4;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM file_upload WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, uploadId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                String fileName = rs.getString("name");
                Blob blob = rs.getBlob("image");
                InputStream inputStream = blob.getBinaryStream();
                int fileLength = inputStream.available();
                System.out.println("fileLength = " + fileLength);

                ServletContext context = getServletContext();

                // sets MIME type for the file download
                
                response.setContentType("image/gif");
               // response.setContentLength(fileLength);
               // String headerKey = ;
               // String headerValue = String.format("attachment; fileName=\"%s\"", fileName);
                response.setHeader("Content-Disposition","inline;fileName=\""+fileName+"\"" );
                // writes the file to the client
                OutputStream outStream = response.getOutputStream();
               // byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while ((bytesRead = inputStream.read()) != -1) {
                    outStream.write(bytesRead);
                }
                inputStream.close();
                outStream.close();

            } else {
                // no file found
                response.getWriter().print("File not found for the id: " + uploadId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
