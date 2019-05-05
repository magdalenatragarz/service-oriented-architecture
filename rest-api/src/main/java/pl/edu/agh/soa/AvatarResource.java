package pl.edu.agh.soa;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("avatar")
public class AvatarResource {

    @Inject
    StudentContainer studentContainer;

    @POST
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response uploadAvatar(@PathParam("id") Integer id, @Valid Avatar avatar) {
       if (studentContainer.uploadAvatar(id,avatar))
           return Response.status(200).build();
       return Response.status(400).build();
    }

    @GET
    @Path("/{id}")
    public Response downloadAvatar(@PathParam("id") Integer id) {
        if (studentContainer.downloadAvatar(id))
            return Response.status(200).build();
        return Response.status(400).build();
    }

}
