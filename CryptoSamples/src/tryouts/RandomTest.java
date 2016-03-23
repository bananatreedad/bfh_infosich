package tryouts;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class RandomTest {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		SecureRandom rnd = new SecureRandom(); 

		System.out.println(rnd.toString());
		System.out.println(rnd.generateSeed(1));

		byte[] byteArr = "Jonathan".getBytes();
		System.out.println(Integer.toBinaryString(byteArr[0]));
		
	   Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

	   System.out.println( "\nCrypto Provider: " + cipher.getProvider().getInfo() );
		
	}

}
