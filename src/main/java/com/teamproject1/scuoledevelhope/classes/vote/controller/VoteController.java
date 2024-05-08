package com.teamproject1.scuoledevelhope.classes.vote.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
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
    @GetMapping("/all")
    public BaseResponseList<VoteDto> findAll() {
        return voteService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/{idStudent}")
    public BaseResponseList<VoteDto> findByStudent(@Valid @PathVariable Long idStudent) {
        return voteService.findByStudent(idStudent);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @PostMapping("/save")
    public BaseResponseElement<VoteDto> add(@Valid @RequestBody VoteDto voteDTO) {
        return voteService.addVote(voteDTO);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @DeleteMapping("/delete")
    public BaseResponseElement<VoteDto> delete(@RequestParam Long idStudent, @RequestParam Long idVote) {
        return voteService.deleteVote(idStudent, idVote);
    }

}
