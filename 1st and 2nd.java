import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

public class AES {
    public static void main(String[] args) throws Exception {
        String key = "1234567890123456"; // 16-character key
        String msg = "Hi AES!";

        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");

        // Encryption
        c.init(Cipher.ENCRYPT_MODE, k);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(msg.getBytes()));
        System.out.println("Enc: " + enc);

        // Decryption
        c.init(Cipher.DECRYPT_MODE, k);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));
        System.out.println("Dec: " + dec);
    }
}
