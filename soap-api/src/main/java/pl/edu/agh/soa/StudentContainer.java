package pl.edu.agh.soa;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentContainer {

    List<Student> students;
    List<Subject> subjects;

    @PostConstruct
    public void init(){
        students = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public List<Student> getStudentsInstance(){
        return students;
    }

    public List<Subject> getSubjectsInstance(){
        return subjects;
    }
}
