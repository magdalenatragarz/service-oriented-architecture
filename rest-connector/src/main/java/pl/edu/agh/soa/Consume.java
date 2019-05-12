package pl.edu.agh.soa;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;
;

public class Consume {

    private static final String URL = "http://localhost:8080/rest-api/student/";

    public static void main(String[] args) {


        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        System.out.println(value);
        response.close();

    }
}
