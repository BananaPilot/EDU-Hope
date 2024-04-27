package com.teamproject1.scuoledevelhope.classes.tutor;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @MapsId
    private User user;

    @NotEmpty(message = "Associates at least 1 class.")
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY
    )
    private List<Classes> classes;

    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY
    )
    private List<Register> registers;

    @PreRemove
    private void preDelete() {
        registers.forEach(register -> register.setTutor(null));
        classes.forEach(cla -> cla.setTutor(null));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }
}
