package pl.edu.agh.soa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-05-09T12:31:28.319+02:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://soa.agh.edu.pl/", name = "StudentSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface StudentSoap {

    @WebMethod
    @RequestWrapper(localName = "downloadAvatar", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.DownloadAvatar")
    @ResponseWrapper(localName = "downloadAvatarResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.DownloadAvatarResponse")
    @WebResult(name = "isSuccess", targetNamespace = "")
    public boolean downloadAvatar(
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId
    );

    @WebMethod
    @RequestWrapper(localName = "addSubject", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddSubject")
    @ResponseWrapper(localName = "addSubjectResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddSubjectResponse")
    @WebResult(name = "isSuccess", targetNamespace = "")
    public boolean addSubject(
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId,
        @WebParam(name = "subjectName", targetNamespace = "")
        java.lang.String subjectName,
        @WebParam(name = "ects", targetNamespace = "")
        int ects
    );

    @WebMethod
    @RequestWrapper(localName = "filterBySurname", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.FilterBySurname")
    @ResponseWrapper(localName = "filterBySurnameResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.FilterBySurnameResponse")
    @WebResult(name = "students", targetNamespace = "")
    public java.util.List<pl.edu.agh.soa.Student> filterBySurname(
        @WebParam(name = "surname", targetNamespace = "")
        java.lang.String surname
    );

    @WebMethod
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddStudentResponse")
    @WebResult(name = "isSuccess", targetNamespace = "")
    public boolean addStudent(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "surname", targetNamespace = "")
        java.lang.String surname,
        @WebParam(name = "stidentId", targetNamespace = "")
        int stidentId
    );

    @WebMethod
    @RequestWrapper(localName = "getStudents", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudents")
    @ResponseWrapper(localName = "getStudentsResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsResponse")
    @WebResult(name = "students", targetNamespace = "")
    public java.util.List<pl.edu.agh.soa.Student> getStudents();

    @WebMethod
    @RequestWrapper(localName = "filterByName", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.FilterByName")
    @ResponseWrapper(localName = "filterByNameResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.FilterByNameResponse")
    @WebResult(name = "students", targetNamespace = "")
    public java.util.List<pl.edu.agh.soa.Student> filterByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebMethod
    @RequestWrapper(localName = "uploadAvatar", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.UploadAvatar")
    @ResponseWrapper(localName = "uploadAvatarResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.UploadAvatarResponse")
    @WebResult(name = "isSuccess", targetNamespace = "")
    public boolean uploadAvatar(
        @WebParam(name = "path", targetNamespace = "")
        java.lang.String path,
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId
    );

    @WebMethod
    @RequestWrapper(localName = "findByid", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.FindByid")
    @ResponseWrapper(localName = "findByidResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.FindByidResponse")
    @WebResult(name = "student", targetNamespace = "")
    public pl.edu.agh.soa.Student findByid(
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId
    );

    @WebMethod
    @RequestWrapper(localName = "removeStudent", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.RemoveStudent")
    @ResponseWrapper(localName = "removeStudentResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.RemoveStudentResponse")
    @WebResult(name = "isSuccess", targetNamespace = "")
    public boolean removeStudent(
        @WebParam(name = "studentId", targetNamespace = "")
        int studentId
    );
}
