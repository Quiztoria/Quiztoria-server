package org.quiztoria.server;


import org.quiztoria.server.entities.Question;
import org.quiztoria.server.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
            @RequestParam(value = "yearEnd") int yearEnd
    ){
        return repo.findByDateEndGreaterThanEqualAndDateStartLessThanEqual(yearBegin,yearEnd, PageRequest.of(page, itemsPerPage));
    }



    @GetMapping("/by-time-range/all")
    public List<Question> searchAllQuestionsByTimeRange(
            @RequestParam(value = "yearBegin") int yearBegin,
            @RequestParam(value = "yearEnd") int yearEnd
    ){
        return repo.findAllByDateEndGreaterThanEqualAndDateStartLessThanEqual(yearBegin,yearEnd);
    }

    @GetMapping("/by-time-range/random")
    public List<Question> drawQuestionsByTimeRange(
            @RequestParam(value = "yearBegin") int yearBegin,
            @RequestParam(value = "yearEnd") int yearEnd,
            @RequestParam(value = "number") int number
    ){
        List<Question> all = repo.findAllByDateEndGreaterThanEqualAndDateStartLessThanEqual(yearBegin,yearEnd);
        List<Question> result = new ArrayList<>();
        Set<Integer> usedIndexes = new HashSet<>();
        Random rand = new Random();
        for(int i = 0; i < number; i++){
            int nextId = rand.nextInt(all.size());
            while(usedIndexes.contains(nextId)) nextId = rand.nextInt(all.size());
            result.add(all.get(nextId));
            usedIndexes.add(nextId);
        }
        return result;
    }
}
