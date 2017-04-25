package com.fianYear.project.icis;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Abdoulr
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        StudentBean bean = new StudentBean();
        bean.setFirstName("adam");
        bean.setLastName("silver");
        bean.setPassword("345267");
        String date="2012-09-01";
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-dd-MM");
        java.util.Date date1 = dateFormat.parse(date);
        java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
        bean.setDob(sqlStartDate);
        bean.setEmail("Adam@gmail.com");
        bean.setGender("female");
        bean.setTelephone("0788835642");
        bean.setNationalId("5567531891981");
        bean.setProvince("North");
        bean.setDistrict("gasabo");
        bean.setSector("kinka");
        bean.setCell("Rugo");
        bean.setVillage("Gsaa");
        bean.setFatherName("Karori");
        bean.setMotherName("yoyo");
        bean.setPreviousSchool("Saint");
        bean.setCombination("MPG");
        bean.setGrade(4.00);
        bean.setStudentClass("Engr");
        bean.setAcademicYear("2012-2013");
        
        SponsorBean sb=SponsorBean.findOneSponsor("3");
        bean.setSponsor(sb);
        DepartmentBean db=DepartmentBean.findOneDepartment("1");
        bean.setDepartment(db);
        StudentBean.createStudent(bean);
        System.out.println("data inserted kabisa!!!");

    }

}
