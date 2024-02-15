package com.practice.springsecauthserver.config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class GenerateCodeVerifierAndChallenge {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        GenerateCodeVerifierAndChallenge gc = new GenerateCodeVerifierAndChallenge();
        String verifier = gc.generateCodeVerifier();
        String challenge = gc.generateCodeChallenge(verifier);
        //String challenge = gc.generateCodeChallenge("qPsH306-ZDDaOE8DFzVn05TkN3ZZoVmI_6x4LsVglQI");

        System.out.println("verifier: " + verifier);
        System.out.println("challenge: "+ challenge);
    }
    String generateCodeVerifier() throws UnsupportedEncodingException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] codeVerifier = new byte[32];
        secureRandom.nextBytes(codeVerifier);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier);
    }

    String generateCodeChallenge(String codeVerifier) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytes = codeVerifier.getBytes("US-ASCII");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] digest = messageDigest.digest();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
    }

}
