package com.binar.chapter6.service;

import com.binar.chapter6.model.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceService {

    @Autowired
    FilmsServiceImpl filmsService;
    @Autowired
    UsersServiceImpl usersService;


    //source how to path jasper : https://github.com/nitinsurana/jasper-java-examples/blob/master/JasperReports/src/javaapplication7/MyReport.java
    public void generateInvoice(HttpServletResponse response) throws JRException, IOException {
        String path = "src/main/resources/invoice.jrxml";
        JasperReport sourceFileName = JasperCompileManager.compileReport(path);

//        List<Map<String, Object>> fillInvoice = new ArrayList<>();
//        Map<String, Object> fill = new HashMap<>();

//        List<Users> users = usersService.getUser();
//        List<Films> films = filmsService.getFilm();
//        List<Schedules> schedules = filmsService.getScheduleDate();
//        List<Seats> seats = filmsService.getSeat();
//        List<Seats> studio = filmsService.getStudio();
//        String seatForU = seats + "" + studio;
//
//        fill.put("user", users);
//        fill.put("filmName", films);
//        fill.put("schedule", schedules);
//        fill.put("seat", seatForU);
//        fillInvoice.add(fill);

        //example generated jasper report pdf
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("user", "user : ngab_owi666");
        parameters.put("filmName", "Title : Daily Life of Queen Puan");
        parameters.put("schedule", "Time : 12 Desember 2022");
        parameters.put("seat", "Seat : C 13");

        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, new JREmptyDataSource());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=invoice.pdf;");

        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}

