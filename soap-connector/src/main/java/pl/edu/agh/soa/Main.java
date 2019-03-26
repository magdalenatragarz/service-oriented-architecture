package pl.edu.agh.soa;

import javax.xml.ws.BindingProvider;

public class Main {

    public static void addCredentials(StudentService service){
        BindingProvider prov = (BindingProvider) service;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user2");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "passwd");
    }

    public static void main(String[] args) {
        StudentServiceService service = new StudentServiceService();
        StudentService studentService = service.getStudentServicePort();
        addCredentials(studentService);
        System.out.println(studentService.addStudent("Magdalena","Tragarz",289792));
        System.out.println(studentService.getStudents());
    }

}
