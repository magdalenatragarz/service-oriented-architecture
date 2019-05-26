package pl.edu.agh.soa;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class StudentDao extends AbstractDao {

    private static final Logger LOGGER = Logger.getLogger("SoaLab" + StudentDao.class.toString());

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentJPA> getType() {
        return StudentJPA.class; //klasa z modeli JPA z adnotacjami @Entity @Table
    }

}