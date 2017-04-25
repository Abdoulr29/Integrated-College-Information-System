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
@WebServlet(urlPatterns={"/UpdateSponsor"})
public class UpdateSponsor extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sponsorId=request.getParameter("id");
        SponsorBean bean=new SponsorBean();
        bean.setSponserId(Integer.parseInt(sponsorId));
        bean.setSponsorName("rwanda Ex");
        bean.setSponserTelephone("0878612317");
        bean.setSponsorEmail("abc@hotmail.cc");
        SponsorBean.updateSponsor(bean);
        response.sendRedirect("sponsor.jsp");
        
        
    }
    
    
}
