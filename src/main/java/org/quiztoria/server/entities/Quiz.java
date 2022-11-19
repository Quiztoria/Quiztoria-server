package org.quiztoria.server.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quiz{
    @Id
    @GeneratedValue
    @Getter
    private Long Id;
    @Getter
    @Setter
    private String QuizName;
    @OneToMany
    @Getter
    @Setter
    private List<Question> Questions;


    public void nullId(){
        this.Id = null;
    }
    public void ensureId(Long l){
        this.Id = l;
    }
}
