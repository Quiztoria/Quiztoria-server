package org.quiztoria.server;

import org.quiztoria.server.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionRESTController {
    @Autowired
    private QuestionRepo repo;
    @GetMapping("/{id}")
    public Optional<Question> getQuestion(@PathVariable Long id){
        return repo.findById(id);
    }
}
