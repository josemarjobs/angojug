package com.angojug.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Util {
  public static String hex(byte[] array) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
	  sb.append(Integer.toHexString((array[i]
	      & 0xFF) | 0x100).substring(1,3));        
      }
      return sb.toString();
  }
  public static String md5Hex (String message) {
      try {
	  MessageDigest md = 
	      MessageDigest.getInstance("MD5");
	  return hex (md.digest(message.getBytes("CP1252")));
      } catch (NoSuchAlgorithmException e) {
      } catch (UnsupportedEncodingException e) {
      }
      return null;
  }
}
//String email = "someone@somewhere.com";
//String hash = MD5Util.md5Hex(email);
//Gravatar gravatar = new Gravatar();
//gravatar.setSize(50);
//gravatar.setRating(GravatarRating.GENERAL_AUDIENCES);
//gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
//String url = gravatar.getUrl("iHaveAn@email.com");
//byte[] jpg = gravatar.download("info@ralfebert.de");
