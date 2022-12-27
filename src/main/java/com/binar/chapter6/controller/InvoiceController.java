package com.binar.chapter6.controller;

import com.binar.chapter6.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Operation(summary = "show generated invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/pdf"))
    })
    @GetMapping("/get_invoice")
    @PreAuthorize(value = "hasAuthority('CUSTOMER')")
    public ResponseEntity getInvoice(HttpServletResponse response) {
        try {
            invoiceService.generateInvoice(response);
            return ResponseEntity.status(HttpStatus.OK).body("show success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("failed to show (CODE 502), caused by : " + e.getMessage());
        }
    }
}
