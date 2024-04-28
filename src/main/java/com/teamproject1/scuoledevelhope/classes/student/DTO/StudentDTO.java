package com.teamproject1.scuoledevelhope.classes.student.DTO;

import jakarta.validation.constraints.NotNull;

public class StudentDTO {

    @NotNull(message = "L'utente dello studente non può essere nullo")
    private Long userId;

    @NotNull(message = "La classe dello studente non può essere nullo")
    private Long schoolClassId;

    @NotNull(message = "Il registro dello studente non può essere nullo")
    private Long registerId;

    public StudentDTO() {
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }
}


