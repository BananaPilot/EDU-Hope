package com.teamproject1.scuoledevelhope.classes.tutor;

import com.teamproject1.scuoledevelhope.classes.clazz.Clazz;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @MapsId
    private User user;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY
    )
    private List<Clazz> classes;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY
    )
    private List<Register> registers;

    public List<Clazz> getClasses() {
        return classes;
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

    public Long getId() {
        return id;
    }

    public static final class TutorBuilder {
        private Long id;
        private User user;
        private List<Clazz> classes;
        private List<Register> registers;

        private TutorBuilder() {
        }

        public static TutorBuilder aTutor() {
            return new TutorBuilder();
        }

        public TutorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TutorBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public TutorBuilder withClasses(List<Clazz> classes) {
            this.classes = classes;
            return this;
        }

        public TutorBuilder withRegisters(List<Register> registers) {
            this.registers = registers;
            return this;
        }

        public Tutor build() {
            Tutor tutor = new Tutor();
            tutor.setUser(user);
            tutor.setRegisters(registers);
            tutor.id = this.id;
            tutor.classes = this.classes;
            return tutor;
        }
    }
}
