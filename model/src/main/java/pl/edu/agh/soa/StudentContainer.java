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
    public void init() {
        students = new ArrayList<>();
        //subjects = new ArrayList<>();
    }

    public List<Student> getStudentsInstance() {
        return students;
    }

    public List<Subject> getSubjectsInstance() {
        return subjects;
    }


    public boolean addStudent(Student student) {
        if (students.stream().noneMatch(s -> s.getStudentId() == student.getStudentId())) {
            students.add(student);
            return true;
        }
        return false;
    }

    public Student findStudentByid(int studentId) {
        return students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public boolean addSubject(int studentId, Subject subject) {
        if (exists(studentId)) {
            findStudentByid(studentId).addSubject(subject);
            return true;
        }
        return false;
    }

    public boolean updateStudent(Integer studentId, Student updatedStudent) {
        if (exists(studentId) && studentId.equals(updatedStudent.getStudentId())
                || exists(studentId) && !exists(updatedStudent)) {
            Student student = findStudentByid(studentId);
            student.setStudentId(updatedStudent.getStudentId());
            student.setSubjects(updatedStudent.getSubjects());
            student.setName(updatedStudent.getName());
            student.setSurname(updatedStudent.getSurname());
            student.setAvatar(updatedStudent.getAvatar());

            
            return true;
        }
        return false;
    }

    private boolean exists(Student student) {
        return students.stream().anyMatch(s -> s.getStudentId() == student.getStudentId());
    }

    private boolean exists(Integer studentId) {
        return students.stream().anyMatch(s -> s.getStudentId() == studentId);
    }


}
