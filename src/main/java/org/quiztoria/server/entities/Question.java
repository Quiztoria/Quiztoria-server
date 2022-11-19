package org.quiztoria.server.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Getter
    private Long Id;
    @Setter
    private String QuestionString;
    @Setter
    private String AnswCorrect;
    @Setter
    private String AnswOpt1;
    @Setter
    private String AnswOpt2;
    @Setter
    private String AnswOpt3;
    @Setter
    private Date DateStart;
    @Setter
    private Date DateEnd;

    public List<String> getAnswers(){
        return null;
    }

    public String getCorrectAnswer(){
        return this.AnswCorrect;
    }
}
