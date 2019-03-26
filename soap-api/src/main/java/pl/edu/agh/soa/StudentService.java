package pl.edu.agh.soa;

import org.jboss.annotation.ejb.Clustered;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService
@DeclareRoles({"developer", "admin"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
@SecurityDomain("soap_lab1")
public class StudentService {

    private WebServiceContext wsContext;
    private static List<Student> students = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();

    @WebMethod
    @WebResult(name = "isSuccess")
    @RolesAllowed("developer")
    public boolean addStudent(@WebParam(name = "name") @XmlElement(required = true) String name,
                              @WebParam(name = "surname") @XmlElement(required = true) String surname,
                              @WebParam(name = "stidentId") @XmlElement(required = true) Integer studentId) {

        if (students.stream().anyMatch(s -> s.getStudentId() == studentId))
            return false;

        students.add(new Student(name, surname, studentId));
        return true;
    }

    @WebMethod
    @WebResult(name = "isSuccess")
    @RolesAllowed("developer")
    public boolean removeStudent(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId) {
        if (students.stream().noneMatch(s -> s.getStudentId() == studentId))
            return false;
        students.removeIf(s -> s.getStudentId() == studentId);
        return true;
    }


    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> getStudents() {
        return students;
    }

    @WebMethod
    @WebResult(name = "isSuccess")
    @PermitAll
    public boolean addSubject(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId,
                              @WebParam(name = "subjectName") @XmlElement(required = true) String subjectName,
                              @WebParam(name = "ects") @XmlElement(required = true) Integer ects) {
        if (students.stream().noneMatch(s -> s.getStudentId() == studentId))
            return false;

        if (subjects.stream().noneMatch(s -> s.name.equals(subjectName) && s.ECTS.equals(ects)))
            subjects.add(new Subject(subjects.size() + 1, subjectName, ects));

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
    @WebResult(name = "subjects")
    @PermitAll
    public List<Subject> getSubjects() {
        return subjects;
    }


    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterBySubject(@WebParam(name = "subjectId") @XmlElement(required = true) Integer subjectId) {
        return students.stream()
                .filter(s -> s.getSubjects().stream()
                        .anyMatch(sub -> sub.subjectId.equals(subjectId)))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterByName(@WebParam(name = "name") @XmlElement(required = true) String name) {
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterBySurname(@WebParam(name = "surname") @XmlElement(required = true) String surname) {
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name = "student")
    @PermitAll
    public Student findByid(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId) {
        return students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    @WebMethod
    @WebResult(name = "isSuccess")
    @PermitAll
    public boolean uploadAvatar(@WebParam(name = "path") @XmlElement(required = true) String path, @WebParam(name = "studentId") Integer studentId) {
        if (students.stream().noneMatch(s -> s.getStudentId() == studentId))
            return false;

        String base64Image = "";
        File file = new File(path);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (Exception e) {
            return false;
        }

        students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null)
                .setAvatar(base64Image);
        return true;
    }


    @WebMethod
    @WebResult(name = "destination-filepath")
    @PermitAll
    public String downloadAvatar(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId) {
        if (students.stream().noneMatch(s -> s.getStudentId() == studentId))
            return "Unknown studentId";

        String base64Image = students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null)
                .getAvatar();

        String destinationFilepath = "/home/magda/students/avatars/student" + studentId.toString() + ".jpg";
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFilepath)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (Exception e) {
            return "Unable to save file";
        }
        return destinationFilepath;
    }
}
