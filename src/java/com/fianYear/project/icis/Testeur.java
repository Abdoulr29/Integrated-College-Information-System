/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns = {"/Testeur"})
public class Testeur extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        InputStream inputStream = null;
        byte[] b = null;
        TestDbFiles files = new TestDbFiles();
        try {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List list = upload.parseRequest(request);
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                FileItem fileItem = (FileItem) itr.next();
                if (!fileItem.isFormField()) {
                    b = fileItem.get();
                }
            }

            files.setUsername("abdoul");
            files.setMyImage(b);
            TestDbFiles.createMyTest(files);

        } catch (FileUploadException ex) {
            ex.printStackTrace();
        }

    }

}
