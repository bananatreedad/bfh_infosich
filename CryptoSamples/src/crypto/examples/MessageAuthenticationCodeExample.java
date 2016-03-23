package crypto.examples;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
//
// In this example we generate a Message Authentication Code on a specific plainText with a shared secret of your choice 
//
public class MessageAuthenticationCodeExample {

  public static void main (String[] args) throws Exception {
	// read file to byte array
	   Path path = Paths.get("test.txt");
	   byte[] plainText = Files.readAllBytes(path); 
	   
    /**
    // get a key for the HMAC-SHA1 algorithm
    System.out.println( "\ngenerate a SHA1 key" );
    KeyGenerator keyGen = KeyGenerator.getInstance("HMACSHA1");
    SecretKey Sha1key = keyGen.generateKey();
	System.out.println( "Key Plaintext: " + Sha1key);  
    **/
	   
	// determine a secret key of your choice for the HMAC
	   String Plainkey = "a specific shared secret";
	   System.out.println( "Key Plaintext: " + Plainkey);
	   byte[] key = (Plainkey).getBytes("UTF-8");
	   
	   // Construct a secret key from the given byte array
	   SecretKeySpec Sha1key = new SecretKeySpec(key, "HMACSHA1");
	   // let's have a look at this key as an array of strings
	   System.out.println( "Used key: " + Arrays.toString (key));  
	   
    // get a MAC object and update it with the plaintext
    Mac mac = Mac.getInstance("HMACSHA1");
    mac.init(Sha1key);
    //mac.update(plainText);
    
    // Compute the HMAC using mac.doFinal(input buffer) in a array of bytes which we call: 'hmac'...
    
	/** Your code comes here **/
    
    // ...end 'hmac' operation.
    
    // print out the provider used
    System.out.println( "\n" + mac.getProvider().getInfo() );

    // printout the length and the value of the message digest 
	System.out.println( "\nMAC Algorithm: " + mac.getAlgorithm());    
	System.out.println( "MAC Length: " + hmac.length*8 + "-Bit");
	System.out.println( "\nMAC:" + "\n- in binary form: ");
	System.out.println( new String (hmac, "UTF8"));
	System.out.println( "\n- in hex code: " + DatatypeConverter.printHexBinary(hmac));
  }
}
