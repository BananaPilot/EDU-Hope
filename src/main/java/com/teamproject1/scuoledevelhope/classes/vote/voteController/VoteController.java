package com.teamproject1.scuoledevelhope.classes.vote.voteController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.voteService.VoteService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {
    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-all")
    public BaseResponseList<Vote> findAll() {
        return voteService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Vote> findById(@RequestParam Long id) {
        return voteService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @PostMapping("/save")
    public BaseResponseElement<Vote> save(@RequestBody Vote vote) {
        return voteService.save(vote);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Vote> delete(@RequestParam Long id) {
        return voteService.deleteById(id);
    }
}
