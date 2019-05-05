package pl.edu.agh.soa;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentContainer {

    List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
    }

    public List<Student> getStudentsInstance() {
        return students;
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

    public boolean removeStudent(Integer studentId) {
        if (!exists(studentId))
            return false;
        students.removeIf(s -> s.getStudentId() == studentId);
        return true;
    }

    public boolean uploadAvatar(Integer studentId, Avatar avatar){
        if (!exists(studentId))
            return false;
        avatar.encode();
        findStudentByid(studentId).setAvatar(avatar);
        return true;
    }

    public boolean downloadAvatar(Integer studentId){
        if (!exists(studentId))
            return false;
        String destinationPath = System.getProperty("user.home")+"/student"+studentId+".jpg";
        try(FileOutputStream imageOutFile = new FileOutputStream(destinationPath)) {
            imageOutFile.write(findStudentByid(studentId).getAvatar().decode());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private boolean exists(Student student) {
        return students.stream().anyMatch(s -> s.getStudentId() == student.getStudentId());
    }

    private boolean exists(Integer studentId) {
        return students.stream().anyMatch(s -> s.getStudentId() == studentId);
    }


}
