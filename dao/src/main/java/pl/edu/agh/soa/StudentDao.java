package pl.edu.agh.soa;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class StudentDao extends AbstractDao {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentJPA> getType() {
        return StudentJPA.class;
    }

}