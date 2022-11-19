package org.quiztoria.server.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quiz{
    @Id
    @GeneratedValue
    private Long Id;
    private String QuizName;
    private List<Question> Questions;

}
