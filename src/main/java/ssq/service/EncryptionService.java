package ssq.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ssq.AESUtil;
import ssq.dao.TransactionObject;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
public class EncryptionService {

    String plainText = "www.baeldung.com";
    String password = "baeldung";
    String salt = "12345678";
    String initVector = "RandomInitVector"; // 16 bytes IV
    String algorithm = "AES/CBC/PKCS5Padding";

    IvParameterSpec iv = null;
    SecretKey key = null;

    EncryptionService(){
        iv = AESUtil.generateIv();
        try {
            key = AESUtil.getKeyFromPassword(password,salt);
        }catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public String encryptData(TransactionObject transactionObject){
        try {
            String transactionString = new ObjectMapper().writeValueAsString(transactionObject);
            return AESUtil.encryptPasswordBased(transactionString, key, iv);
        }catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | InvalidKeyException | IOException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
