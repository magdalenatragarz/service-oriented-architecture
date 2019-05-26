package pl.edu.agh.soa;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Student{

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Min(100000)
    @Max(999999)
    private Integer studentId;

    private Avatar avatar;

    private List<Subject> subjects;

    public Student() {
        this.subjects = new ArrayList<>();
    }


    public Student(String name, String surname, int studentId) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }


    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentId=" + studentId +
                ", avatar=" + avatar +
                ", subjects=" + subjects +
                '}';
    }
}
