package pl.edu.agh.soa;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


//http://localhost:8080/rest-api/student/getStudent

@Path("student")
public class StudentRestService {

    @Inject
    StudentContainer studentContainer;

    @GET
    @Path("/getStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents(){
        return studentContainer.getStudentsInstance();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student findById(@PathParam("id") Integer id){
        return studentContainer.findStudentByid(id);
    }

    @POST
    @Path("/addStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(@Valid Student student){
        if (studentContainer.addStudent(student))
            return Response.status(200).build();
        return Response.status(400).build();
    }

}

