package pl.edu.agh.soa;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("student")
public class StudentResource {

    @Inject
    private StudentContainer studentContainer;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentContainer.getStudentsInstance();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(@Valid Student student) {
        if (studentContainer.addStudent(student))
            return Response.status(200).build();
        return Response.status(400).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student findById(@PathParam("id") int id) {
        return studentContainer.findStudentByid(id);
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("id") int id, @Valid Student updatedStudent) {
        if (studentContainer.updateStudent(id, updatedStudent))
            return Response.status(200).build();
        return Response.status(400).build();
    }


}

