package net.spy.jutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.StringBuilder;

/**
 * @author Jason Hudgins <jasonlee@spy.net>
 *
 */
public class DigestUtil {

  /**
   * Method to return the md5 of a supplied string.
   * 
   * @param text the string you want to make a digest for.
   * @return the generated md5
   * @throws NoSuchAlgorithmException
   */
  public static String md5String(String text) throws NoSuchAlgorithmException{
    
    MessageDigest algorithm = MessageDigest.getInstance("MD5");
    algorithm.update(text.getBytes());
    
    byte[] digest = algorithm.digest();
    
    StringBuilder hexString = new StringBuilder();
    for (int i=0; i < digest.length; i++) {
      hexString.append(Integer.toHexString(0xFF & digest[i]));
    }      
   
    return hexString.toString();
  }
}
