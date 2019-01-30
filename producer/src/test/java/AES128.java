import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author Administrator
 */
public class AES128 {

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "neteasenewsboard";
        // 需要加密的字串
        String cSrc = "www.gowhere.so";
        System.out.println(cSrc);
        // 加密
        String enString = AES128.Encrypt(cSrc, cKey);
//        System.out.println("加密后的字串是：" + enString);

        // 解密
//        String content = "fflMmJk/kiYhdpsOksYjes2NiN5YhkVJXahphKrmaPDv1dH8+EwdMkxnhpyk79VBIIGNeE0nI41SFrBIaL1THA==";
        String content =  "rzDMV34XEn8R81ipWy2wCEKWcg0/p5x97B1Ug4Btby1Qhxwr6FGCQ4diDav+zNov";
        byte[] arr = org.apache.commons.codec.binary.Base64.decodeBase64(content.getBytes());
        SecretKeySpec key = new SecretKeySpec(cKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(2, key);// 初始化
        byte[] result = cipher.doFinal(arr);// 加密/解密
        System.out.println("解密后 ： "+ new String(result) );
//        CryptService.decrypt("fflMmJk%2FkiYhdpsOksYjes2NiN5YhkVJXahphKrmaPDv1dH8%2BEwdMkxnhpyk79VBIIGNeE0nI41SFrBIaL1THA%3D%3D");
//        String test = new String(Base64.decodeBase64(str), "utf-8");
//        String DeString = AES128.Decrypt(test, cKey);
//        System.out.println("解密后的字串是：" + DeString);
    }
}

