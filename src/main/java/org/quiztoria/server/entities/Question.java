package org.quiztoria.server.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
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
    @Getter
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

    @JsonIgnore
    public void nullId(){
        this.Id = null;
    }
    public void ensureId(Long l){
        this.Id = l;
    }

    public List<String> getAnswers(){
        List<String> answ = new ArrayList<>();
        answ.add(this.AnswCorrect);
        answ.add(this.AnswOpt1);
        answ.add(this.AnswOpt2);
        answ.add(this.AnswOpt3);
        return null;
    }

    public String getCorrectAnswer(){
        return this.AnswCorrect;
    }
}
