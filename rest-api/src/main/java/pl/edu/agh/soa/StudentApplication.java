package pl.edu.agh.soa;

import javax.ws.rs.core.Application;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class StudentApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(StudentRestService.class);
        return s;
    }
}
