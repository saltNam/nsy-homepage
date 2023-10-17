package com.nsy.homepage.converter;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

import javax.persistence.Converter;


import java.util.Base64;


@Converter(autoApply = false)
public class EmailConverter implements AttributeConverter<String, String> {

    private static final String KEY = "12345678901234567890123456789012";
    private static final String IV = KEY.substring(0, 16);

    // 이메일 AES 암호화
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
                byte[] keyBytes = new byte[16];
                byte[] b = KEY.getBytes("UTF-8");
                int len = Math.min(b.length, keyBytes.length);
                System.arraycopy(b, 0, keyBytes, 0, len);

                SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
                Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
                c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(IV.getBytes()));

                byte[] encrypted = c.doFinal(attribute.getBytes("UTF-8"));
                return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return null;
    }
}
