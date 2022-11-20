package org.quiztoria.server;

import org.quiztoria.server.entities.Question;
import org.quiztoria.server.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionRESTController {
    @Autowired
    private QuestionRepo repo;
    @GetMapping("/{id}")
    public Optional<Question> getQuestion(@PathVariable Long id){
        return repo.findById(id);
    }

    /**
     * Creates a new question
     * @param q
     * @return
     */
    @PostMapping
    public Question newQuestion(@RequestBody Question q){
        q.nullId();
        return repo.saveAndFlush(q);
    }

    @PostMapping("/{id}")
    public Question editQuestion(@RequestBody Question q, @PathVariable Long id){
        q.ensureId(id);
        return repo.saveAndFlush(q);
    }

    @GetMapping
    public List<Question> getPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "itemsPerPage", defaultValue = "10") int itemsPerPage
    )  {
        return repo.findAll(PageRequest.of(page, itemsPerPage)).getContent();
    }
}
