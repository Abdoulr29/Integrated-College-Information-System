/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

/**
 *
 * @author Abdoulr
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns={"/DeleteSponsor"})

public class DeleteSponsor extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String sponsorId=request.getParameter("id");
        SponsorBean bean=new SponsorBean();
        bean.setSponserId(Integer.parseInt(sponsorId));
        SponsorBean.deleteSponsor(bean);
        response.sendRedirect("sponsor.jsp");
        
    }
    
    
}
