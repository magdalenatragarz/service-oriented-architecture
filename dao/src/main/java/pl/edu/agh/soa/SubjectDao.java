package pl.edu.agh.soa;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class SubjectDao extends AbstractDao {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<SubjectJPA> getType() {
        return SubjectJPA.class;
    }

}