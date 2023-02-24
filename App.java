
import java.util.concurrent.TimeUnit;
import java.security.PrivateKey;
import java.security.PublicKey;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TP062153
 */

public class App { 
  
  public static void main(String[] args) throws Exception{
      tstMySignature();
      System.out.println("-----------------------------------");
      System.out.println("Lab Exercise");
      SignatureAliceBob();
  }
  
  public static void tstMySignature() throws Exception{
      /* Demo: create the key pair*/
      MyKeyPair.create();
      PublicKey publicKey = MyKeyPair.getPublicKey();
      PrivateKey privateKey = MyKeyPair.getPrivateKey();
      
      MySignarture sig = new MySignarture();
      
      String data = "simple digital signature demo";
      System.out.println("Data: "+ data);
      
      /*sign the data w/ private key*/
      String signature = sig.sign(data, privateKey);
      System.out.println("Signature: "+ signature);
      
      System.out.println("\n> Transfering...");
      TimeUnit.SECONDS.sleep(3);
      System.out.println("> Transferred.");
      
      //verify
      System.out.println();
      boolean isValid = sig.verify(data, signature, publicKey);
      System.out.println((isValid)? ">>Correct!": ">>Incorrect!");
      
      System.out.println("> Done...");
  }
/*Exercise: Generate the signature for the following transaction record.
  "alice|bob|credit|100.0";"alice|bob|debit|200.0";
  */
  public static void SignatureAliceBob() throws Exception{
      /* Demo: create the key pair*/
      MyKeyPair.create();
      PublicKey publicKey = MyKeyPair.getPublicKey();
      PrivateKey privateKey = MyKeyPair.getPrivateKey();
      
      PublicKey publicKey2 = MyKeyPair.getPublicKey();
      PrivateKey privateKey2 = MyKeyPair.getPrivateKey();
      
      MySignarture sig = new MySignarture();
      
      String data = "alice|bob|credit|100.0";
      System.out.println("Data: "+ data);
      
      /*sign the data w/ private key*/
      String signature = sig.sign(data, privateKey);
      System.out.println("Signature: "+ signature);
      System.out.println("Data: "+ data+ "|" + signature);
      
      System.out.println("\n> Transfering...");
      TimeUnit.SECONDS.sleep(3);
      System.out.println("> Transferred.");
      
      String data2 = "alice|bob|debit|200.0";
      
      /*sign the data w/ private key*/
      String signature2 = sig.sign(data2, privateKey2);
      System.out.println("Signature: "+ signature2);
      System.out.println("Data: "+ data+ "|" + signature2);
      
      System.out.println("\n> Transfering...");
      TimeUnit.SECONDS.sleep(3);
      System.out.println("> Transferred.");
      
      //verify
      System.out.println();
      boolean isValid = sig.verify(data, signature, publicKey);
      System.out.println((isValid)? ">>Correct!": ">>Incorrect!");
      
      System.out.println();
      boolean isValid2 = sig.verify(data2, signature2, publicKey2);
      System.out.println((isValid2)? ">>Correct!": ">>Incorrect!");
      
      System.out.println("> Done...");
  }
  
 
  
  
}
