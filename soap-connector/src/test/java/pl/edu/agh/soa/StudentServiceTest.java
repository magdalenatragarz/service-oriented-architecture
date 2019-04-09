package pl.edu.agh.soa;

import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.BindingProvider;

import static org.junit.Assert.*;

public class StudentServiceTest {

    private StudentServiceService service;
    private StudentService studentService;

    @Before
    public void setUp() {
        service =  new StudentServiceService();
        studentService = service.getStudentServicePort();
        addCredentials(studentService);
        studentService.erase();
    }

    public static void addCredentials(StudentService service){
        BindingProvider prov = (BindingProvider) service;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user2");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "passwd");
    }

    @Test
    public void shouldAddStudent() {
        studentService.erase();
        boolean result = studentService.addStudent("John","Doe",289791);
        assertTrue(result);
    }

    @Test
    public void shouldNotAddStudent() {
        studentService.erase();
        studentService.addStudent("John","Doe",289791);
        boolean result = studentService.addStudent("John","Doe",289791);
        assertFalse(result);
    }

}