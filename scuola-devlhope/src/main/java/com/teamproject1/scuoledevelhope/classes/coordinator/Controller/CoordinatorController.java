package com.teamproject1.scuoledevelhope.classes.coordinator.Controller;

import com.teamproject1.scuoledevelhope.classes.coordinator.service.CoordinatorService;
import com.teamproject1.scuoledevelhope.classes.tutor.tutorService.TutorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordinatorController {
    private CoordinatorService coordinatorService;
    TutorService tutorController;

    public CoordinatorController(TutorService tutorService) {
        this.coordinatorService = coordinatorService;
    }


    }
