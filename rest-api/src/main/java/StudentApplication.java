import auth.AuthenticationFilter;
import pl.edu.agh.soa.AuthenticationResource;
import pl.edu.agh.soa.AvatarResource;
import pl.edu.agh.soa.StudentResource;
import pl.edu.agh.soa.SubjectResource;

import javax.ws.rs.core.Application;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class StudentApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(StudentResource.class);
        s.add(SubjectResource.class);
        s.add(AvatarResource.class);
        s.add(AuthenticationResource.class);
        s.add(AuthenticationFilter.class);
        return s;
    }
}
