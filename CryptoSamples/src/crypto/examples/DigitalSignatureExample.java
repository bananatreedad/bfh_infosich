package crypto.examples;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;
//
// In this example we use the digital signature feature to generate and verify a signature of a hash value
//
public class DigitalSignatureExample {

  public static void main (String[] args) throws Exception {
	// read file to byte array
	   Path signPath = Paths.get("test.txt");
	   byte[] signText = Files.readAllBytes(signPath); 
	   
    // generate an RSA keypair
    System.out.println( "\ngenerated RSA keys:" );
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(2048);
    KeyPair key = keyGen.generateKeyPair();
    byte [] privkey = key.getPrivate().getEncoded();
    System.out.println( "Private Key: " + DatatypeConverter.printHexBinary(privkey));
    byte [] pubkey = key.getPublic().getEncoded();
    System.out.println( "Public Key: " + DatatypeConverter.printHexBinary(pubkey));
  
    // get a signature object using the SHA-256 and RSA combined algorithm
    // load the private key used to sign data
    // update the data to be signed with the specified array of bytes: 'plainText'

    Signature signer = Signature.getInstance("SHA256WithRSA");
    signer.initSign(key.getPrivate());
    signer.update(signText);
    
    // Sign the already loaded data using signer.sign() and put the output in a array of bytes which we call: 'signature'...
    
	/** Your 1. code comes here **/
    
    // ...end of signature operation.
    
    // printout used algorithm and crypto provider
	System.out.println( "\nselected Algorithm: " + signer.getAlgorithm());
    System.out.println( "\nusing crypto provider:" );
    System.out.println( signer.getProvider().getInfo() );
    
    // printout signature value
    System.out.println( "\nSignature:" + "\n- in binary format: ");
    System.out.println( new String(signature, "UTF8") );
	System.out.println( "\n- MIME encoded (base64): \n" + Base64.getMimeEncoder().encodeToString(signature));
    
    // verify the signature with the public key
    System.out.println( "\nSignature verification:" );
    
    // first we load the original message again, by reading the file to a byte array
	   Path verifyPath = Paths.get("test_2.txt");
	   byte[] verifyText = Files.readAllBytes(verifyPath); 
    
    // first we create a signature object for the verifier using the same algorithm parameter 'SHA256WithRSA'
    // load the public key used to verify the signature
    // update the data to be verified with the specified array of bytes: 'plainText'
    
    Signature verifier = Signature.getInstance("SHA256WithRSA");
	verifier.initVerify(key.getPublic());
    verifier.update(verifyText);
    
    // Try to verify the signature using verifier.verify(signature). If successful, printout a corresponding message. 
    // if not, printout a kind of a "signature failure message"...
    
	/** Your 2. code comes here **/
    
    // ...end signature verification process.
  }
}