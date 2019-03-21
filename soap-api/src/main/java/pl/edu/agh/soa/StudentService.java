package pl.edu.agh.soa;

import org.hibernate.validator.constraints.LuhnCheck;
import org.jboss.annotation.ejb.Clustered;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.xml.bind.annotation.XmlElement;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.apache.commons.io.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Base64;

@Stateless
@WebService
@DeclareRoles({"developer","admin"})
@WebContext(authMethod="BASIC", transportGuarantee="NONE")
@SecurityDomain("soap_lab1")
public class StudentService {

    private static List<Student> students = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();

    @WebMethod
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

    @WebMethod
    @WebResult(name="isSuccess")
    @RolesAllowed("developer")
    public boolean removeStudent(@WebParam(name="studentId") @XmlElement(required = true) Integer studentId){
        if (students.stream().noneMatch(s -> s.getStudentId()==studentId))
            return false;
        students.removeIf(s -> s.getStudentId()==studentId);
        return true;
    }


    @WebMethod
    @WebResult(name="students")
    @PermitAll
    public List<Student> getStudents(){
        return students;
    }

    @WebMethod
    @WebResult(name="isSuccess")
    @PermitAll
    public boolean addSubject(@WebParam(name="studentId") @XmlElement(required=true) Integer studentId,
                              @WebParam(name="subjectName") @XmlElement(required=true) String subjectName,
                              @WebParam(name="ects") @XmlElement(required=true) Integer ects){
        if (students.stream().noneMatch(s -> s.getStudentId()==studentId))
            return false;

        if(subjects.stream().noneMatch(s -> s.name.equals(subjectName) && s.ECTS.equals(ects)))
            subjects.add(new Subject(subjects.size()+1, subjectName, ects));

        Subject subject = subjects.stream()
                .filter(s -> s.name.equals(subjectName) && s.ECTS.equals(ects))
                .findFirst()
                .get();

        students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null)
                .addSubject(subject);

        return true;
    }

    @WebMethod
    @WebResult(name="subjects")
    @PermitAll
    public List<Subject> getSubjects(){
        return subjects;
    }


    @WebMethod
    @WebResult(name="students")
    @PermitAll
    public List<Student> filterBySubject(@WebParam(name="subjectId") @XmlElement(required = true) Integer subjectId){
        return students.stream()
                .filter(s -> s.getSubjects().stream()
                        .anyMatch(sub -> sub.subjectId.equals(subjectId)))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name="students")
    @PermitAll
    public List<Student> filterByName(@WebParam(name="name") @XmlElement(required=true) String name){
        return students.stream()
                    .filter(s -> s.getName().equals(name))
                    .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name="students")
    @PermitAll
    public List<Student> filterBySurname(@WebParam(name="surname") @XmlElement(required=true) String surname){
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name="student")
    @PermitAll
    public Student findByid(@WebParam(name="studentId") @XmlElement(required=true) Integer studentId){
        return students.stream()
                .filter(s -> s.getStudentId()==studentId)
                .findFirst()
                .orElse(null);
    }

    @WebMethod
    @WebResult(name="avatar")
    @PermitAll
    public boolean uploadAvatar(@WebParam(name="path") @XmlElement(required=true) String path, @WebParam(name="studentId") Integer studentId){
        try{
            File file = new File(path);
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            String encodedFile = new String(Base64.getEncoder().encode(bytes));
            Optional<Student> student = students.stream()
                    .filter(s -> s.getStudentId()==studentId)
                    .findFirst();
            student.ifPresent(s -> s.setAvatar(encodedFile));
            return true;
        } catch (IOException e){
            return false;
        }
    }

}
