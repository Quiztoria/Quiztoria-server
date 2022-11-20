package org.quiztoria.server;

import org.quiztoria.server.entities.Question;
import org.quiztoria.server.entities.Quiz;
import org.quiztoria.server.repo.QuestionRepo;
import org.quiztoria.server.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @PostMapping("/{id}/addquestions")
    public Quiz addQuestions(@RequestBody List<Long> questionId, @PathVariable Long id){
        Quiz q = repo.findById(id).get();
        for (Long qid:questionId) {
            q.getQuestions().add(questions.findById(qid).get());
        }
        return repo.saveAndFlush(q);
    }

    @DeleteMapping("{id}")
    public boolean deleteQuiz(@PathVariable Long id){
        repo.deleteById(id);
        return true;
    }

    @DeleteMapping("{id}/{qid}")
    public Quiz deleteQuiz(@PathVariable Long id,@PathVariable Long qid){
        Quiz q = repo.findById(id).get();
        List<Question> newQuestions = new ArrayList<Question>();
        for (int i = 0; i<q.getQuestions().size();i++){
            if(!q.getQuestions().get(i).getId().equals(qid)){
                newQuestions.add(q.getQuestions().get(i));
            }
        }

        q.setQuestions(newQuestions);
        return repo.saveAndFlush(q);
    }
}
