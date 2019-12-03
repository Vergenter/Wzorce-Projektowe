import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class User {
    private final SecretKey secretKey;
    private final Secrets secrets;
    public User(SecretKey secretKey,Secrets secrets){
        this.secretKey=secretKey;
        this.secrets=secrets;
    }
    String sendMessage(final String message) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        return secrets.encryptString(message,secretKey);
    }
    String receiveMessage(final String encryptedMessage) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        return secrets.decryptString(encryptedMessage,secretKey);
    }
}
