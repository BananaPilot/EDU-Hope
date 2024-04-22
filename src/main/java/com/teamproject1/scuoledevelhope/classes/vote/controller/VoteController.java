package com.teamproject1.scuoledevelhope.classes.vote.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.service.VoteService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
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
    public BaseResponseElement<Vote> findById(@Valid @RequestParam Long id) {
        return voteService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-by-student")
    public BaseResponseList<Vote> getVoteByStudent(@Valid @RequestParam Long id) {
        return voteService.getVoteByStudent(id);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @PostMapping("/save")
    public BaseResponseElement<Vote> save(@Valid @RequestBody Vote vote) {
        return voteService.save(vote);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Vote> delete(@Valid @RequestParam Long id) {
        return voteService.deleteById(id);
    }
}
