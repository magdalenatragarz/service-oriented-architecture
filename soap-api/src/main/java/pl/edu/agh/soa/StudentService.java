package pl.edu.agh.soa;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        try {
            students.stream()
                    .filter(s -> s.getStudentId() == studentId)
                    .findFirst()
                    .orElse(null)
                    .addSubject(subjectName, ects);
        }catch(NullPointerException e){
            return false;
        }
        return true;
    }

}
