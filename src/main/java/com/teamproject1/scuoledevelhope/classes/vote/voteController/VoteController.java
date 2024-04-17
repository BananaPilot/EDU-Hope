package com.teamproject1.scuoledevelhope.classes.vote.voteController;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.voteService.VoteService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/vote")
public class VoteController {
    VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/get-all")
    public BaseResponseList<Vote> findAll() {
        return voteService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<Vote> findById(@RequestParam UUID id) {
        return voteService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<Vote> save(@RequestBody Vote vote) {
        return voteService.save(vote);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Vote> delete(@RequestParam UUID id) {
        return voteService.deleteById(id);
    }
}
