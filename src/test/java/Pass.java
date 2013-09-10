import java.security.MessageDigest;


public class Pass {

    public static void main(String[] args) throws Exception {
        final MessageDigest messageDigest = java.security.MessageDigest.
                getInstance("SHA-256");
        final byte bin[] = messageDigest.digest(("shin1008").getBytes());
        System.out.println(org.apache.commons.codec.binary.Base64.encodeBase64String(bin));
    }
}
