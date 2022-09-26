package br.com.credsystem.credsystemapp.utils;

import br.com.credsystem.credsystemapp.dtos.request.TransacaoDTORequest;
import br.com.credsystem.credsystemapp.entities.Cartao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.apache.commons.lang3.RandomStringUtils.random;

public class CartaoUtils {
    public static final int COUNT = 4;
    public static final boolean LETTERS = false;
    public static final boolean NUMBERS = true;
    public static final String MASK = "xxxx-xxxx-xxxx-####";

    public static String maskCreditCardNumber(String cardNumber) {

        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < MASK.length(); i++) {
            char c = MASK.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        return maskedNumber.toString();
    }

    public static String generateCreditCardPassword() {
        return random(COUNT, LETTERS, NUMBERS);
    }

    public static boolean isValidCreditCardPassword(TransacaoDTORequest transacao, Cartao cartao) throws NoSuchAlgorithmException {
        return cartao.getSenha().equals(
                crypto(transacao.getSenha())
        );
    }

    public static String crypto(String password) throws NoSuchAlgorithmException {

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();

    }
}
