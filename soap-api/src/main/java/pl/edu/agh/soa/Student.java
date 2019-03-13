package pl.edu.agh.soa;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    public String name;
    public String surname;
    public Integer studentId;
    public List<Subject> subjects;


    public Student(String name, String surname, int studentId) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getStudentId() {
        return studentId;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String subjectName, Integer ects){
        subjects.add(new Subject(subjectName,ects));
    }


}
