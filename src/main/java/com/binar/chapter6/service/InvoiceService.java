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

        List<Map<String, String>> fillInvoice = new ArrayList<>();
        Map<String, String> fill = new HashMap<>();

        Users users = usersService.getUser();
        Films films = filmsService.getFilm();
        Schedules schedules = filmsService.getScheduleDate();
        Seats seats = filmsService.getSeatStudio();
        String seatForU = seats.getSeatNumber() + ", " + seats.getStudioName();

        fill.put("user", users.getUsername());
        fill.put("film", films.getFilmName());
        fill.put("schedule", schedules.getPlayingDate());
        fill.put("seat", seatForU);
        fillInvoice.add(fill);

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(fillInvoice);
        Map<String, Object> parameters = new HashMap<>();

        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=invoice.pdf;");

        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}

