package br.com.cwi.crescer.exerc.aula5.infraestrutura;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServicoDeCriptografia {

    public static String criptografar(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            MessageDigest cripto = MessageDigest.getInstance("MD5");
            byte[] array = cripto.digest(senha.getBytes("UTF-8"));  //convert the byte to hex format method 1
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toString((array[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.err.println("Problema na encriptação da senha.");
            throw e;
        }
    }
}
