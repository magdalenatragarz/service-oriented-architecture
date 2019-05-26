package pl.edu.agh.soa;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class SubjectDao extends AbstractDao {

    private static final Logger LOGGER = Logger.getLogger("SoaLab" + SubjectDao.class.toString());

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<SubjectJPA> getType() {
        return SubjectJPA.class; //klasa z modeli JPA z adnotacjami @Entity @Table
    }

}