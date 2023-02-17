/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.keygenerator;

import java.util.Base64;
import java.security.PublicKey;
import java.security.PrivateKey;
/**
 *
 * @author TP062153
 */
public class App {
    
    
    public static void main(String[] args) throws Exception{
//        MyKeyPair.create();
//        byte[] publicKey = MyKeyPair.getPublicKey().getEncoded();
//        byte[] privateKey = MyKeyPair.getPrivateKey().getEncoded();
//        
//        MyKeyPair.put(publicKey, "MyKeyPair/PublicKey");
//        MyKeyPair.put(privateKey, "MyKeyPair/PrivateKey");
//        
//        System.out.println("Public Key = "+ Base64.getEncoder().encodeToString(publicKey));
//        System.out.println("Private Key = "+ Base64.getEncoder().encodeToString(privateKey));
    
        PublicKey pubKey = KeyAccess.getPublicKey("MyKeyPair/PublicKey");
        PrivateKey privKey = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
        System.out.println("Public Key = "+ Base64.getEncoder().encodeToString(pubKey.getEncoded()));
        System.out.println("Private Key = "+ Base64.getEncoder().encodeToString(privKey.getEncoded()));
    }
}
