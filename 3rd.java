import java.security.*;

public class RSASignature {
    public static void main(String[] args) throws Exception {
        String msg = "Hello RSA Signature";

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        KeyPair kp = keyGen.generateKeyPair();

        Signature sign = Signature.getInstance("SHA256withRSA");

        // Signing
        sign.initSign(kp.getPrivate());
        sign.update(msg.getBytes());
        byte[] signature = sign.sign();
        System.out.println("Signature: " + new String(signature));

        // Verification
        sign.initVerify(kp.getPublic());
        sign.update(msg.getBytes());
        System.out.println("Verified: " + sign.verify(signature));
    }
}