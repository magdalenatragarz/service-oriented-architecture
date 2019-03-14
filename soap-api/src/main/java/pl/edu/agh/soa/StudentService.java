package pl.edu.agh.soa;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.xml.bind.annotation.XmlElement;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService
@DeclareRoles({"developer","admin"})
@WebContext(authMethod="BASIC", transportGuarantee="NONE")
@SecurityDomain("soap_lab1")
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    @WebMethod(action="getStudents")
    @WebResult(name="isSuccess")
    @RolesAllowed("developer")
    public boolean addStudent(@WebParam(name="name") @XmlElement(required=true)  String name ,
                              @WebParam(name="surname") @XmlElement(required=true) String surname,
                              @WebParam(name="stidentId") @XmlElement(required=true) Integer studentId){

        if (students.stream().anyMatch(s -> s.getStudentId()==studentId))
            return false;

        students.add(new Student(name, surname, studentId));
        return true;
    }

    @WebMethod(action="getStudents")
    @WebResult(name="students")
    @PermitAll
    public List<Student> getStudents(){
        return students;
    }

    @WebMethod(action="addSubject")
    @WebResult(name="isSuccess")
    @PermitAll
    public boolean addSubject(@WebParam(name="studentId") @XmlElement(required=true) Integer studentId,
                              @WebParam(name="subjectName") @XmlElement(required=true) String subjectName,
                              @WebParam(name="ects") @XmlElement(required=true) Integer ects){
        if (students.stream().noneMatch(s -> s.getStudentId()==studentId))
            return false;

        students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null)
                .addSubject(subjectName, ects);

        return true;
    }

    @WebMethod(action="filterByName")
    @WebResult(name="students")
    @PermitAll
    public List<Student> filterByName(@WebParam(name="name") @XmlElement(required=true) String name){
        return students.stream()
                    .filter(s -> s.getName().equals(name))
                    .collect(Collectors.toList());
    }

    @WebMethod(action="filterBySurname")
    @WebResult(name="students")
    @PermitAll
    public List<Student> filterBySurname(@WebParam(name="surname") @XmlElement(required=true) String surname){
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    @WebMethod(action="findById")
    @WebResult(name="student")
    @PermitAll
    public Student findByid(@WebParam(name="studentId") @XmlElement(required=true) Integer studentId){
        return students.stream()
                .filter(s -> s.getStudentId()==studentId)
                .findFirst()
                .orElse(null);
    }

}
