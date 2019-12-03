import co.tunjos.crypto.crypto.AesKeySizes;
import co.tunjos.crypto.crypto.CryptoUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecretsController implements Secrets{
    private final byte[] initializationVector = new byte[16];
    private final CryptoUtils cryptoUtils = CryptoUtils.getInstance();

    @Override
    public String encryptString(final String toEncrypt, SecretKey secretKey) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return cryptoUtils.encryptAES256String(toEncrypt, initializationVector, secretKey);
    }

    @Override
    public String decryptString(final String toDecrypt, SecretKey secretKey) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return cryptoUtils.decryptAES256String(toDecrypt, initializationVector, secretKey);
    }

    @Override
    public SecretKey getNewKey() throws NoSuchAlgorithmException {
        return cryptoUtils.generateAESKey(AesKeySizes.AES_128);
    }
    SecretsController(){
        new SecureRandom().nextBytes(initializationVector);
    }
}
