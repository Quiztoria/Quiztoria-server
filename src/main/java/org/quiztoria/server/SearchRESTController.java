package org.quiztoria.server;


import org.quiztoria.server.entities.Question;
import org.quiztoria.server.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*")
public class SearchRESTController {
    @Autowired
    private QuestionRepo repo;

    @GetMapping("/by-time-range")
    public List<Question> searchQuestionsByTimeRange(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "itemsPerPage", defaultValue = "10") int itemsPerPage,
            @RequestParam(value = "yearBegin") int yearBegin,
            @RequestParam(value = "yearBegin") int yearEnd
    ){
        return null;
    }



    @GetMapping("/by-time-range/all")
    public List<Question> searchAllQuestionsByTimeRange(
            @RequestParam(value = "yearBegin") int yearBegin,
            @RequestParam(value = "yearBegin") int yearEnd
    ){
        return null;
    }
}
