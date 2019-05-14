package pl.edu.agh.soa;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class Consume {

    private static final String endpoint = "http://localhost:8080/rest-api";

    public static void main(String[] args) {


        Student student1 = new Student("John","Doe",289796);
        Subject subject1 = new Subject("SOA",5);
        Subject subject2 = new Subject("Wzorce Projektowe", 7);

        Subject s1 = new Subject("SOA",5);
        student1.getSubjects().add(s1);

        Avatar avatar = new Avatar("/home/magda/soa/sample.jpg");
        student1.setAvatar(avatar);
        student1.getAvatar().encode();

        String token = login("admin","admin");
        System.out.println(addStudent(student1,token));
        System.out.println(getStudents());
        System.out.println(getStudentById(289796));



    }

    private static String login(String username, String password){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(endpoint);
        Form form = new Form();
        form.param("username", username).param("password",password);
        Response response = target
                .path("/login")
                .request()
                .post(Entity.form(form));
        client.close();
        return response.readEntity(String.class);
    }

    private static int addStudent(Student student, String JWT){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(endpoint);
        Response response = target
                .path("/student")
                .request()
                .header("Authorization",JWT)
                .post(Entity.entity(student, MediaType.APPLICATION_JSON ));
        client.close();
        return response.getStatus();
    }

    private static List<Student> getStudents(){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(endpoint);
        Response response = target
                .path("/student")
                .request()
                .get();
        client.close();
        return response.readEntity(new GenericType<List<Student>>() {});
    }

    private static Student getStudentById(int id){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(endpoint);
        Response response = target
                .path("/student/" + id)
                .request()
                .get();
        client.close();
        return response.readEntity(Student.class);
    }


}
