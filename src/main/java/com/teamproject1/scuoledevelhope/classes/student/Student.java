package com.teamproject1.scuoledevelhope.classes.student;

import com.teamproject1.scuoledevelhope.classes.classes.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @MapsId
    private User user;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes schoolClass;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;

    public Student() {
    }

    public Student(User user, Classes schoolClass, Register register) {
        this.user = user;
        this.schoolClass = schoolClass;
        this.register = register;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Classes getSchoolClass() {
        return schoolClass;
    }

    public Register getRegister() {
        return register;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSchoolClass(Classes schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setRegister(Register register) {
        this.register = register;
    }


    public static final class StudentBuilder {
        private Long id;
        private User user;
        private Classes schoolClass;
        private Register register;

        private StudentBuilder() {
        }

        public static StudentBuilder aStudent() {
            return new StudentBuilder();
        }

        public StudentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public StudentBuilder withSchoolClass(Classes schoolClass) {
            this.schoolClass = schoolClass;
            return this;
        }

        public StudentBuilder withRegister(Register register) {
            this.register = register;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.setUser(user);
            student.setSchoolClass(schoolClass);
            student.setRegister(register);
            student.id = this.id;
            return student;
        }
    }
}
