/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns={"/SponsorServlet"})
public class SponsorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String sponsorName=request.getParameter("sponsorName");
        String sponsorContact=request.getParameter("sponsorContact");
        String sponsorEmail=request.getParameter("sponsorEmail");
        SponsorBean bean=new SponsorBean();
        bean.setSponsorName(sponsorName);
        bean.setSponserTelephone(sponsorContact);
        bean.setSponsorEmail(sponsorEmail);
        SponsorBean.createSponsor(bean);
        response.sendRedirect("sponsor.jsp");
    }
    
}
