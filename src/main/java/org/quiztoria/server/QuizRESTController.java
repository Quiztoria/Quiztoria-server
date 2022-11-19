package org.quiztoria.server;

import org.quiztoria.server.entities.Quiz;
import org.quiztoria.server.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "*")
public class QuizRESTController {

    @Autowired
    private QuizRepo repo;

    @GetMapping("/{id}")
    public Optional<Quiz> getQuiz(@PathVariable Long id){
        return repo.findById(id);
    }
    @PostMapping
    public Quiz newQuiz(@RequestBody Quiz q){
        q.nullId();
        return repo.save(q);
    }
    @PostMapping("/{id}")
    public Quiz editQuiz(@RequestBody Quiz q, @PathVariable Long id){
        q.ensureId(id);
        return repo.save(q);
    }


}
