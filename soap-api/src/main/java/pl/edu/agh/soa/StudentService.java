package pl.edu.agh.soa;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    @WebMethod
    public boolean addStudent(@WebParam(name="name") String name,
                              @WebParam(name="surname") String surname,
                              @WebParam(name="stidentId") Integer studentId){

        if (students.stream().anyMatch(s -> s.getStudentId()==studentId))
            return false;

        students.add(new Student(name, surname, studentId));
        return true;
    }

    @WebMethod
    public List<Student> getStudents(){
        return students;
    }

    @WebMethod
    public boolean addSubject(@WebParam(name="studentId") Integer studentId,
                              @WebParam(name="subjectName") String subjectName,
                              @WebParam(name="ects") Integer ects){
        if (students.stream().noneMatch(s -> s.getStudentId()==studentId))
            return false;

        students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null)
                .addSubject(subjectName, ects);

        return true;
    }

    @WebMethod
    public List<Student> filterByName(String name){
        return students.stream()
                    .filter(s -> s.getName().equals(name))
                    .collect(Collectors.toList());
    }

    @WebMethod
    public List<Student> filterBySurname(String surname){
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    @WebMethod
    public Student findByid(Integer studentId){
        return students.stream()
                .filter(s -> s.getStudentId()==studentId)
                .findFirst()
                .orElse(null);
    }

}
