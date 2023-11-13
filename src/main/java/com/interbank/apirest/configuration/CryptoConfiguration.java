package com.interbank.apirest.configuration;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.context.annotation.Configuration;


public class CryptoConfiguration {

  public static String encrypt(String code){
    return Base64.getEncoder().encodeToString(code.getBytes(StandardCharsets.UTF_8));
 }
  public static String decrypt(String code){
    return new String(Base64.getDecoder().decode(code));
  }

}
