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
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.CONFLICT).entity("studentId must be unique, student already exists").build();
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
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Student doesn't exist").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeStudent(@PathParam("id") int id) {
        if (studentContainer.removeStudent(id))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Student doesn't exist").build();
    }

}

