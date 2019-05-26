package pl.edu.agh.soa;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class AvatarDao extends AbstractDao {

    private static final Logger LOGGER = Logger.getLogger("SoaLab" + AvatarDao.class.toString());

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<AvatarJPA> getType() {
        return AvatarJPA.class; //klasa z modeli JPA z adnotacjami @Entity @Table
    }

}