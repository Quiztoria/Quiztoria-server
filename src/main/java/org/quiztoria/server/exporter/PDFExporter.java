package org.quiztoria.server.exporter;

import com.itextpdf.html2pdf.HtmlConverter;
import org.quiztoria.server.entities.Question;
import org.quiztoria.server.entities.Quiz;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class PDFExporter {

    public static ByteArrayInputStream exportPDF(List<Question> l/*HttpServletRequest request, HttpServletResponse response*/){
        ByteArrayOutputStream out = new ByteArrayOutputStream();




        HtmlConverter.convertToPdf(createSimpleHTML(l), out);

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static String createSimpleHTML(List<Question> l){
        String html="<html><body><center><h1>Quiz</h1></center>";
        int i = 0;
        for (Question q:l) {
            html+=createSimpleHTMLforOne(q,i++);
        }
        return html+"</body></html>";
    }
    public static String createSimpleHTMLforOne(Question q, int num){
        String a= "<br><h4><b>"+(num+1)+") "+q.getQuestionString()+"</b></h4>";
        a+="<br>";
        List<String> answ = q.getAnswers();
        Collections.shuffle(answ);
        for (char i = 'a'; i<'e';i++)
            a+="<p>"+i+". "+ answ.get(i - 'a')+"</p>";
        a+="<br><hr>";
        return a;
    }

    public static String CreateHTMLTemplate(Quiz q){
        ModelAndView mav = new ModelAndView("quiz");


        return "";
    }
}
