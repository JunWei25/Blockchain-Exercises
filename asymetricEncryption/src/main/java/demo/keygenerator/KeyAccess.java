/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.keygenerator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
/**
 *
 * @author TP062153
 */
public class KeyAccess {
    public static PublicKey getPublicKey(String path) throws Exception
    {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        //note convert the keyBytes into appropriate keyspec
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }
    
    public static PrivateKey getPrivateKey(String path) throws Exception
    {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        //note convert the keyBytes into appropriate keyspec
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePrivate(spec);
    }
}
