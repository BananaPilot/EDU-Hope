package model;

import jakarta.persistence.*;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String schoolYear;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes cl;
    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    public Integer getId() {
        return id;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public Classes getId_class() {
        return cl;
    }

    public Tutor getId_tutor() {
        return tutor;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id: " + id +
                ", schoolYear: '" + schoolYear + '\'' +
                ", id_class: " + cl +
                ", id_tutor: " + tutor +
                '}';
    }
}
