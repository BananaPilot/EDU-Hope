package com.teamproject1.scuoledevelhope.classes.tutor.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class TutorDTO {

    @NotNull(message = "L'ID del tutor non può essere nullo")
    private Long id;

    @NotNull(message = "L'ID dell'utente del tutor non può essere nullo")
    private Long userId;

    @NotEmpty(message = "Il tutor deve essere associato ad almeno una classe")
    private List<Long> classIds;

    public TutorDTO() {
    }
    
    public Long getUserId() {
        return userId;
    }

    public List<Long> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Long> classIds) {
        this.classIds = classIds;
    }
}
