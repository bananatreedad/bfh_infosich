package crypto.examples;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import javax.xml.bind.DatatypeConverter;

//In this example program we read a text from a file and compute a message digest of this content.

public class MessageDigestExample {

	public static void main (String[] args) throws Exception {
			  
		// read file to byte array
		   Path path = Paths.get("test.txt");
		   byte[] plainText = Files.readAllBytes(path); 
	    	
	    // print out the original text 
		   System.out.println( "Plaintext: " );
		   String rebuildedString = new String(plainText);
		   System.out.println("\""+rebuildedString+"\"");
		  
		// Get a MessageDigest object and select an appropriate algorithm using MessageDigest.getInstance(). 
		// Let's call the MessageDigest object 'messDig', because we gonna use it in the next section...
		
		   /** Your 1. code comes here **/
		   
        // ...end getting a MessageDigest object.
		   
	    // print out the used crypto provider
		   System.out.println( "\nCrypto Provider: " + messDig.getProvider().getInfo());
		   
		// print out selected algorithm
		   System.out.println( "\nAlgorithm: " + messDig.getAlgorithm());
		   
		// Compute the message digest of the input array - byte 'plainText' - using messDig.digest(). 
		// Let's call the resulting hash value of the array of bytes: 'hash', once again - just because we use it afterwards...
		   
		   /** Your 2. code comes here **/ 
		   
	    // ...end computation of the message digest.
		   
	    // printout the length and the value of the message digest   
		   System.out.println( "\nDigest Length: " + hash.length*8 + "-Bit");
		   System.out.println( "\nDigest in hex code: " + DatatypeConverter.printHexBinary(hash));
  }
}