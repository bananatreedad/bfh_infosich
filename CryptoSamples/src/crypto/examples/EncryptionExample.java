package crypto.examples;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// In this example program we read a text from a file and encrypt it using a 128-bit AES cipher.
// After the encryption we decrypt the ciphertext and verify if we get the output again.

public class EncryptionExample {
	static SecureRandom rnd = new SecureRandom();
	static IvParameterSpec iv = new IvParameterSpec(rnd.generateSeed(16));

  public static void main (String[] args) throws Exception {
	// read file to byte array
	   Path path = Paths.get("test.txt");
	   byte[] plainText = Files.readAllBytes(path);
	   
	// determine a personal AES secret key of your choice
	   String Plainkey = "the_most_secret_key_you_know";
	   System.out.println( "Key Plaintext: " + Plainkey);
	   byte[] key = (Plainkey).getBytes("UTF-8");
	   
	   // use only the first 128 bit of the secret if it is to long
	   key = Arrays.copyOf(key, 16);

	   // Construct a secret key from the given byte array
	   SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

	   // let's have a look at this key as an array of strings
	   System.out.println( "Used key: " + Arrays.toString (key));  
	   
	/**
	   // alternatively you may let generate a random AES secret key with a key generator, instead of choosing a personal key 
		  System.out.println( "\nGenerating AES key:" );
		  KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		  keyGen.init(128);
	   // end computing a random AES secret key   
	**/   
    
    // get an instance of an AES cipher object and print the provider
	   Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	   System.out.println( "\nCrypto Provider: " + cipher.getProvider().getInfo() );
    
    // Encrypt the 'plainText' using the created secret key 'secretKey'... 
	   
	   // initialize the cipher using cipher.init(OpMode, Key, AlgorithmParameter) where:
	   //   OpMode = the intended operation: encryption
	   //   Key = the encryption key 
	   //   AlgorithmParameter = the necessary algorithm parameter in dependence of the mode of operation (e.g. CBC)
	   
	 cipher.init(Encription., certificate); 
	   // finally encrypt the plainText using cipher.doFinal(input buffer) in a array of bytes which we call: 'cipherText'
	   
	   /** Your 2. code comes here **/
	   
	// ....end of encryption operation.  
	
	// printout the ciphertext in two modes: as binary data and as MIME object (base64 encoded)
	   System.out.println( "\nEncrypted text:" + "\n- in binary format: ");
	   System.out.println( new String (cipherText, "UTF8"));
	   System.out.println("\n- MIME encoded (base64): \n" + Base64.getMimeEncoder().encodeToString(cipherText));

    // Decrypt the 'cipherText' using the same key 'secretKey'...
	   
	   // initialize the cipher again using cipher.init(OpMode, Key, AlgorithmParameter) where:
	   //   OpMode = the intended operation: decryption
	   //   Key = the encryption key
	   //   AlgorithmParameter = the necessary algorithm parameter in dependence of the mode of operation
	   
	   /** Your 3. code comes here **/
	   
	   // finally decrypt the cipherText using cipher.doFinal(input buffer) in a array of bytes which we call: decryptedPlainText
	   
	   /** Your 4. code comes here **/
	   
	// ...end of decryption operation.   
	   
	// at the end we printout the decrypted PlainText again to verify if it is the same as the original PlainText   
	   System.out.println( "\nDecrypted text:" );
	   System.out.println( new String(decryptedPlainText, "UTF8") );
  }
}