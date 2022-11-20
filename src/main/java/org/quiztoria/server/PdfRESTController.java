package org.quiztoria.server;


import org.quiztoria.server.exporter.PDFExporter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class PdfRESTController {

    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport(){
        ByteArrayInputStream bis = PDFExporter.exportPDF();//GeneratePdfReport.citiesReport(cities);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=quiz.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
