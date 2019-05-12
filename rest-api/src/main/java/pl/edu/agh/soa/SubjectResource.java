package pl.edu.agh.soa;

import auth.Secured;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("subject")
public class SubjectResource {

    @Inject
    private StudentContainer studentContainer;

    @POST
    @Secured
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addSubject(@PathParam("id") Integer id, @Valid Subject subject) {
        if (studentContainer.addSubject(id, subject))
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Student doesn't exist").build();
    }

}
