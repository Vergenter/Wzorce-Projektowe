import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class facadeTest {
    @Test
    public void encryptUsingSecretsFacade() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        final Secrets secrets= new SecretsController();
        final User user = new User(secrets.getNewKey(),secrets);
        final String Message="Hello, World";
        final String expected = Message;
        final String actual=user.sendMessage(Message);
        assertNotEquals(expected,actual);
    }
    @Test
    public void encryptAndDecryptUsingSecretsFacade() throws NoSuchAlgorithmException{
        final Secrets secrets= new SecretsController();
        final SecretKey secretKey=secrets.getNewKey();
        final User first = new User(secretKey,secrets);
        final User second = new User(secretKey,secrets);
        final String Message="Hello, World";
        final String expected = Message;
        final UnaryOperator<String> sendAndReceive=(String message)->{  //this is why functional programming hates exceptions :D
            try {
                return second.receiveMessage(first.sendMessage(message));
            } catch (NoSuchPaddingException | InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                return "";
            }
        };
        final String actual=sendAndReceive.apply(Message);
        assertEquals(expected,actual);
    }
    @Test
    public void useWrongKeyToDecrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        final Secrets secrets= new SecretsController();
        final SecretKey secretKeyOne=secrets.getNewKey();
        final SecretKey secretKeyTwo=secrets.getNewKey();
        final User first = new User(secretKeyOne,secrets);
        final User second = new User(secretKeyTwo,secrets);
        final String Message="Hello, World";
        final String expected = Message;
        try {
            final String actual = second.receiveMessage(first.sendMessage(Message));
            assertNotEquals(expected,actual);
        } catch (BadPaddingException e){
            //means not equal
        }

    }

}
