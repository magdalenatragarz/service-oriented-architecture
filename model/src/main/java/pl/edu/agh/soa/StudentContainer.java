package pl.edu.agh.soa;

import javax.annotation.PostConstruct;
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


    public boolean addStudent(Student student){
        if (students.stream().noneMatch(s -> s.getStudentId() == student.getStudentId()))
            return false;
        students.add(student);
        return true;
    }

    public Student findStudentByid(Integer studentId) {
        return students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

}
