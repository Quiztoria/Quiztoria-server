package org.quiztoria.server.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private Long Id;
    private String QuestionString;
    private String AnswCorrect;
    private String AnswOpt1;
    private String AnswOpt2;
    private String AnswOpt3;
    private Date DateStart;
    private Date DateEnd;

    public List<String> getAnswers(){
        return null;
    }

    public String getCorrectAnswer(){
        return this.AnswCorrect;
    }
}
