package pl.edu.agh.soa;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


@Stateless
@WebService
@DeclareRoles({"developer", "admin"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
@SecurityDomain("soap_lab1")
public class StudentService {

    @Inject
    StudentContainer studentContainer;

    @WebMethod
    @WebResult(name = "isSuccess")
    @RolesAllowed("developer")
    public boolean addStudent(@WebParam(name = "name") @XmlElement(required = true) String name,
                              @WebParam(name = "surname") @XmlElement(required = true) String surname,
                              @WebParam(name = "stidentId") @XmlElement(required = true) int studentId) {

        return studentContainer.addStudent(new Student(name, surname, studentId));
    }

    @WebMethod
    @WebResult(name = "isSuccess")
    @RolesAllowed("developer")
    public boolean removeStudent(@WebParam(name = "studentId") @XmlElement(required = true) int studentId) {
        List<Student> students = studentContainer.getStudentsInstance();
        if (students.stream().noneMatch(s -> s.getStudentId() == studentId))
            return false;
        students.removeIf(s -> s.getStudentId() == studentId);
        return true;
    }


    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> getStudents() {
        return studentContainer.getStudentsInstance();
    }

    @WebMethod
    @WebResult(name = "isSuccess")
    @PermitAll
    public boolean addSubject(@WebParam(name = "studentId") @XmlElement(required = true) int studentId,
                              @WebParam(name = "subjectName") @XmlElement(required = true) String subjectName,
                              @WebParam(name = "ects") @XmlElement(required = true) int ects) {

        return studentContainer.addSubject(studentId, new Subject(subjectName, ects));
    }

    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterByName(@WebParam(name = "name") @XmlElement(required = true) String name) {
        List<Student> students = studentContainer.getStudentsInstance();
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterBySurname(@WebParam(name = "surname") @XmlElement(required = true) String surname) {
        List<Student> students = studentContainer.getStudentsInstance();
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    @WebMethod
    @WebResult(name = "student")
    @PermitAll
    public Student findByid(@WebParam(name = "studentId") @XmlElement(required = true) int studentId) {
        return studentContainer.findStudentByid(studentId);
    }

    @WebMethod
    @WebResult(name = "isSuccess")
    @PermitAll
    public boolean uploadAvatar(@WebParam(name = "path") @XmlElement(required = true) String path, @WebParam(name = "studentId") int studentId) {
        List<Student> students = studentContainer.getStudentsInstance();
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
    public String downloadAvatar(@WebParam(name = "studentId") @XmlElement(required = true) int studentId) {
        List<Student> students = studentContainer.getStudentsInstance();
        if (students.stream().noneMatch(s -> s.getStudentId() == studentId))
            return "Unknown studentId";

        String base64Image = students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null)
                .getAvatar();

        String destinationFilepath = "/home/magda/students/avatars/student" + studentId + ".jpg";
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFilepath)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (Exception e) {
            return "Unable to save file";
        }
        return destinationFilepath;
    }


}
