package pl.edu.agh.soa;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlType(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    private String name;
    private String surname;
    private Integer studentId;
    private String avatar;

    @XmlElementWrapper
    @XmlElement(name = "subject")
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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
}
