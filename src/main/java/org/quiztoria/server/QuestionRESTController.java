package org.quiztoria.server;

import io.swagger.annotations.ApiModel;
import org.quiztoria.server.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/question")
@ApiModel(subTypes = {Question.class})
public class QuestionRESTController {
    @Autowired
    private QuestionRepo repo;
    @GetMapping("/{id}")
    public Optional<Question> getQuestion(@PathVariable Long id){
        return repo.findById(id);
    }

    @PostMapping
    public Question saveQuestion(@RequestBody Question q){
        return repo.saveAndFlush(q);
    }
}
