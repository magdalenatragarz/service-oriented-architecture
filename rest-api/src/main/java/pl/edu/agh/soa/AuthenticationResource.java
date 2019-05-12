package pl.edu.agh.soa;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import auth.KeyGenerator;
import io.jsonwebtoken.Jwts;


@Path("login")
public class AuthenticationResource {

    @Context
    UriInfo uriInfo;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") String username,
                          @FormParam("password") String password) {
        try {
            authenticate(username, password);
            String token = issueToken(username);
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        if (!username.equals("admin") || !password.equals("admin"))
            throw new Exception();
    }

    private String issueToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(KeyGenerator.generateKey())
                .compact();
    }
}

