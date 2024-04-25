package com.teamproject1.scuoledevelhope.classes.vote.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDTO;
import com.teamproject1.scuoledevelhope.classes.vote.repo.VoteDAO;
import com.teamproject1.scuoledevelhope.classes.vote.service.VoteService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {
    private final VoteService voteService;
    @Autowired private VoteDAO voteDAO;
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
    @PostMapping("/save")
    public BaseResponseElement<Vote> save(@Valid @RequestBody Vote vote) {
        return voteService.save(vote);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @PostMapping("/add")
    public BaseResponseElement<Vote> add(@Valid @RequestBody VoteDTO voteDTO) {
        return voteService.add(voteDTO);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Vote> delete(@Valid @RequestParam Long id) {
        return voteService.deleteById(id);
    }

}
