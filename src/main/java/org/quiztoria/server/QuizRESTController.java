package org.quiztoria.server;

import org.quiztoria.server.entities.Quiz;
import org.quiztoria.server.repo.QuestionRepo;
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

    @Autowired
    private QuestionRepo questions;

    @GetMapping("/{id}")
    public Optional<Quiz> getQuiz(@PathVariable Long id){
        return repo.findById(id);
    }
    @PostMapping
    public Quiz newQuiz(@RequestBody String name){
        Quiz q = new Quiz();
        q.setQuizName(name);
        return repo.saveAndFlush(q);
    }
    @PostMapping("/{id}/addquestion")
        public Quiz addQuestion(@RequestBody Long questionId, @PathVariable Long id){
        Quiz q = repo.findById(id).get();
        q.getQuestions().add(questions.findById(questionId).get());
        return repo.saveAndFlush(q);
    }


}
