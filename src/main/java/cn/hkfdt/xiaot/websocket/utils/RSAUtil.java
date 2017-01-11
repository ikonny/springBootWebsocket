package cn.hkfdt.xiaot.websocket.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JCERSAPrivateCrtKey;
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PasswordFinder;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by hzzhaopingfei on 2015/10/5.
 * Powered by Rock
 */
public class RSAUtil extends Coder {
    static String privateKeyFileInfo = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDDGwkSYK1ATXy4\n" +
            "Pc05ZhYli3aOxXfDzekpnGuCTREeOSoMsIgBet1t/FUxl1ABHP5QV6nYBAq2wrNb\n" +
            "8HUS0uqE0jdXFsCxCfRosroaKFaCujfhxOlsKFhq2OrqhHaocWzKJUjTMrnddJJI\n" +
            "5HR81NJ64fK0j5+EY1EOOs1JZsVuALjG7eTpIQW7bNApnm7GHB7huJT4qzrfrGKF\n" +
            "s0nhhdcxGGskJ6RNcqjXdo/eUoAERWY9UXU+VIQwp0/Luus2m7Wk8dCniuBEAoXL\n" +
            "lXcXAHwnl7xZz6C0UviOuvF2JshGOPbTYy9G0/EQ7h1JALhXuB8U81KXfF1fCwNL\n" +
            "peUzVTRhAgMBAAECggEBAJnCt76NBF0V9EG7Kv6ebru+EnxoMX/VyniptqylEeWQ\n" +
            "xYvkn/sSmmmwoG+JwVpvQBmPTOJaJRttjC7b7VgdcwekKErxOoELyFuu5y3wNmWm\n" +
            "Xp4GMrOzhCMIuvKB3IXZhhQ1mBQh+QsHcLYTnZ43l32SjlUwj1Wlc97UBq9fWB7c\n" +
            " /2ayFc/ET7xxv+xBOOidFiCJNe/+Lxh5h3yRxOmpyCsMKy+TtPww3gVmtNKdkx49\n" +
            "G4vp6miFtbwu0/ADgMOu1pacNCbSvqcjAcK2jpIktGmgfmN7gMTDPfUu2BEej8bF\n" +
            " /tX+9LPUj05BhB7siTcHlSPZ6nZOFsxsAEcSGXk0KbECgYEA8dMnHSL6VFVAe/0O\n" +
            "XoyN2FZ7JXXxeGTpOtnqPr5+QeGqM8oKRBOo14aeMmzuSwR4qa/YHhG5/wSxEF8m\n" +
            "9vnG8LqZqgFCw4gQoMyTKbDjVUl/6r5a65GrI3DVWSySCUrQfidIMcQlSvmX3g9O\n" +
            "2SY7H0HCFliMetswg7AtPLst/GUCgYEAzorPP6I3NenKn7EZiDLTJyBV9o9wQ4ZL\n" +
            "B1L/Z4T/PL4pq9Ei8v6BBR197ApyfPWHWJvmcTBcLPc9zfwXmcZm1PoxACCR3jkT\n" +
            "A7ukpvXAusOPqahfhuyekfLdfqHxaK/pSyqY4fznce30p+pDWvcOhHCYwECKTNcP\n" +
            "URhHqPkxgk0CgYEAwUIldSSZ+EG1aiFflXIwfd8HRXXPh47l0ZGLoZ8tWctV8VOb\n" +
            "BrLLcYr07ImfmrY1FC8iwU0bXtHKC7Jvels9gO8vlOyzBX69AzTauyvRUjyODPUZ\n" +
            "xj9BDO7EoiJ7hw+SNe+Aw7zkrNlxZBbJxcLG5wDvclpL0ndPez6VuH5Cjv0CgYA0\n" +
            "KG2p3icfIEkhBrIx6NPV356VwydQhgtQcC87TyS9jDAtyYSP5KFkT0xLXWAIGmDx\n" +
            "iX0qPFIqsM0UxYKYPLgfNIdHRvJPMg6RNMOhvhHLmDMhXvmwsvRgWvqAThkOnM3H\n" +
            "Q5yUBS/VX4gXF1unDxjFbUHF2waR3QVrLzx5eWR9SQKBgGKyAxeuHnDTKMzFcT28\n" +
            "HxCrS2EkYDJR7/tCMcvTlnJeJHjQg7EZc/0iZQ3dFdSD/LrppB1a79WnP32MCplP\n" +
            "IY3tmqCVGTumj/4GkzAJeA8AP/wBF8QXkyxU3IDl4SwkGY25Ms4BS9HiOJmvvRtO\n" +
            "e88F2PuMFZamJ1zeaeDCoRPc\n" +
            "-----END PRIVATE KEY-----";


    public static final String KEY_ALGORTHM = "RSA";//
    public static final String PUBLIC_KEY = "RSAPublicKey";//公钥
    public static final String PRIVATE_KEY = "RSAPrivateKey";//私钥

    /**
     * 用私钥加密
     *
     * @param data 加密数据
     * @param key  密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key) throws Exception {
        //解密密钥
        byte[] keyBytes = decryptBASE64(key);
        //取私钥
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        //对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }


    /**
     * 用私钥解密<span style="color:#000000;"></span> * @param data  加密数据
     *
     * @param key 密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, Key key) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);

        return cipher.doFinal(data);
    }

    /**
     * 用私钥解密<span style="color:#000000;"></span> * @param data  加密数据
     *
     * @param key 密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
        //对私钥解密
        byte[] keyBytes = decryptBASE64(key);

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 用公钥加密
     *
     * @param data 加密数据
     * @param key  密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
        //对公钥解密
        byte[] keyBytes = decryptBASE64(key);
        //取公钥
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    public static RSAPrivateKey initKey(byte[] keyBytes) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        ByteArrayInputStream bais = new ByteArrayInputStream(keyBytes);
        PEMReader reader = new PEMReader(new InputStreamReader(bais), new PasswordFinder() {
            public char[] getPassword() {
                return "".toCharArray();
            }
        });
        JCERSAPrivateCrtKey k = (JCERSAPrivateCrtKey) reader.readObject();
        reader.close();
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) factory.generatePrivate(new PKCS8EncodedKeySpec(k.getEncoded()));
    }

    public static String decodeTokenByKey(RSAPrivateKey key, String token) throws Exception {
        if (key != null) {
            byte[] qu = decryptByPrivateKey(org.bouncycastle.util.encoders.Base64.decode(token), key);
            return new String(qu);
        }
        return null;
    }
}
