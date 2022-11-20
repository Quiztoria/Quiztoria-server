package org.quiztoria.server;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.quiztoria.server.entities.Question;
import org.quiztoria.server.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionRESTController {

    @Autowired
    private QuestionRepo repo;

    @ApiOperation(value = "Get question by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved question"),
            @ApiResponse(code = 404, message = "Question not found")
    })
    @GetMapping("/{id}")
    public Optional<Question> getQuestion(@PathVariable Long id){
        return repo.findById(id);
    }

    /**
     * Creates a new question
     * @param q
     * @return
     */
    @ApiOperation(value = "Creates a new question")
    @ApiResponse(code = 200, message = "Successfully created question")
    @PostMapping
    public Question newQuestion(@RequestBody Question q){
        q.nullId();
        return repo.saveAndFlush(q);
    }

    @ApiOperation(value = "Edit question by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully edited question"),
            @ApiResponse(code = 404, message = "Question not found")
    })
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

    @ApiOperation(value = "Get multiple questions")
    @ApiResponse(code = 200, message = "Successfully retrieved questions")
    @GetMapping("/multiple")
    public List<Question> getMultiple(@RequestParam List<Long> questionIds)  {
        return repo.findAllById(questionIds);
    }

    @ApiOperation(value = "Get all questions")
    @ApiResponse(code = 200, message = "Successfully retrieved all questions")
    @GetMapping("/all")
    public List<Question> getAll()  {
        return repo.findAll();
    }

    @ApiOperation(value = "Delete question")
    @ApiResponse(code = 200, message = "Successfully deleted question")
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        repo.deleteById(id);
        return true;
    }
}
