package pl.edu.agh.soa;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {

        try {

            authenticate(username, password);
            String token = issueToken(username);
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        if (!username.equals("admin") || !password.equals("admin"))
            throw new Exception();
    }

    private String issueToken(String username) {
        return "jwt_test"+username;
    }
}

