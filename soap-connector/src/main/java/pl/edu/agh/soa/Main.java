package pl.edu.agh.soa;

import javax.xml.ws.BindingProvider;

public class Main {
    public static void main(String[] args) {
        StudentServiceService service = new StudentServiceService();
        StudentService studentService = service.getStudentServicePort();
        BindingProvider prov = (BindingProvider) studentService;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user2");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "passwd");
        System.out.println(studentService.addStudent("Magda","Tragarz",289791));
    }
}
