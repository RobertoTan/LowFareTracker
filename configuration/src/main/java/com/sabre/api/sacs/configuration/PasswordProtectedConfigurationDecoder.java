package com.sabre.api.sacs.configuration;

import android.util.Base64;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * Implementation of {@link ConfigurationDecoder} interface.
 * Uses Java's Password Based Encoding with 8-byte salt with DES and MD5.
 */
public class PasswordProtectedConfigurationDecoder implements ConfigurationDecoder {

    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };

    /**
     * Decodes using Password Based Encryption.
     */
    @Override
	public String decode(String encoded) {
    	String result = encoded;
    	try {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        result = new String(pbeCipher.doFinal(Base64.decode(encoded, Base64.DEFAULT)), "UTF-8");
    	} catch (GeneralSecurityException e) {
            e.printStackTrace();
    	} catch (IOException e) {
            e.printStackTrace();
		}
        return result;
	}

}
