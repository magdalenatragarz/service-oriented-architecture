package pl.edu.agh.soa;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class AvatarDao extends AbstractDao {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<AvatarJPA> getType() {
        return AvatarJPA.class;
    }

}