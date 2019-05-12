package auth;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public final class KeyGenerator {

    public static Key generateKey(){
        String keyString = "veryStrongKeyveryStrongKeyveryStrongKeyveryStrongKeyveryStrongKeyveryStrongKeyveryStrongKey";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HMACSHA256");
    }

}
