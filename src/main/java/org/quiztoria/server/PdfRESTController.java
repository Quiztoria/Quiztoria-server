package org.quiztoria.server;


import org.quiztoria.server.exporter.PDFExporter;
import org.quiztoria.server.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins =  "*" )
public class PdfRESTController {
    @Autowired
    QuizRepo repo;

    @RequestMapping(value = "/pdfreport/{quizId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport(@PathVariable Long quizId){
        ByteArrayInputStream bis = PDFExporter.exportPDF(repo.findById(quizId).get().getQuestions());//GeneratePdfReport.citiesReport(cities);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=quiz.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
