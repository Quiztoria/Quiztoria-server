package org.quiztoria.server.exporter;

import com.itextpdf.html2pdf.HtmlConverter;
import org.quiztoria.server.entities.Quiz;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class PDFExporter {

    public static ByteArrayInputStream exportPDF(/*HttpServletRequest request, HttpServletResponse response*/){
        ByteArrayOutputStream out = new ByteArrayOutputStream();




        HtmlConverter.convertToPdf("<h1>AAAAAAA</h1>", out);

        return new ByteArrayInputStream(out.toByteArray());
    }
    public static String CreateHTMLTemplate(Quiz q){
        ModelAndView mav = new ModelAndView("quiz");


        return "";
    }
}
