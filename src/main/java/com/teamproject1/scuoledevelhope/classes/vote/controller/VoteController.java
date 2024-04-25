package com.teamproject1.scuoledevelhope.classes.vote.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDTO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
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
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }
    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/all")
    public BaseResponseList<VoteDTO> findAll() {
        return voteService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping
    public BaseResponseElement<VoteDTO> findById(@Valid @RequestParam Long id) {
        return voteService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @PostMapping("/save")
    public BaseResponseElement<VoteDTO> add(@Valid @RequestBody VoteDTO voteDTO) {
        return voteService.addVote(voteDTO);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @DeleteMapping("/delete")
    public BaseResponseElement<VoteDTO> delete(@RequestParam Long idStudent, @RequestParam Long idVote) {
        return voteService.deleteVote(idStudent, idVote);
    }

}
