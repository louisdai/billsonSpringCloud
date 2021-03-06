//import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.Mac;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class CryptUtil {
//    private static final Logger logger = LoggerFactory.getLogger(CryptUtil.class);
//
//	/**
//	 * 将二进制转换成16进制
//	 *
//	 * @param buf
//	 * @return
//	 */
//	public static String Byte2Hex(byte buf[]) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < buf.length; i++) {
//			String hex = Integer.toHexString(buf[i] & 0xFF);
//			if (hex.length() == 1) {
//				hex = '0' + hex;
//			}
//			sb.append(hex.toUpperCase());
//		}
//		return sb.toString();
//	}
//
//	/**
//	 * 将16进制转换为二进制
//	 *
//	 * @param hexStr
//	 * @return
//	 */
//	public static byte[] Hex2Byte(String hexStr) {
//		if (hexStr.length() < 1)
//			return null;
//		byte[] result = new byte[hexStr.length() / 2];
//		for (int i = 0; i < hexStr.length() / 2; i++) {
//			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
//			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
//			result[i] = (byte) (high * 16 + low);
//		}
//		return result;
//	}
//
//    /**
//     * 转为16进制
//     *
//     * @param b
//     * @return
//     * @throws UnsupportedEncodingException
//     * @throws NumberFormatException
//     */
//    public static byte[] hex2byte(String s) throws NumberFormatException, UnsupportedEncodingException {
//        byte[] b = s.getBytes("utf-8");
//        if ((b.length % 2) != 0)
//            throw new IllegalArgumentException("IllegalArg: "+s);
//        byte[] b2 = new byte[b.length / 2];
//        for (int n = 0; n < b.length; n += 2) {
//            String item = new String(b, n, 2);
//            b2[n / 2] = (byte) Integer.parseInt(item, 16);
//        }
//        return b2;
//    }
//
//	/**
//	 * AES加密/解密
//	 *
//	 * @param mode
//	 *            模式:1加密，2解密
//	 * @param src
//	 *            数据
//	 * @param password
//	 *            密钥
//	 * @return
//	 */
//	public static byte[] aesCrypt(int mode, byte[] content, byte[] password) {
//		try {
//			SecretKey key = new SecretKeySpec(password, "AES");
//			Cipher cp = Cipher.getInstance("AES"); // 创建密码器
//			cp.init(mode, key); // 初始化
//			byte[] ctext = cp.doFinal(content); // 加密/解密
//			return ctext;
//		} catch (Exception e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 加密
//	 * @param content：待加密内容，普通字符串
//	 * @param password：十六进制key，使用前需要先进行hex2byte操作
//	 * @return 加密后的内容，进行byte2hex后的内容
//	 * @throws Exception
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesEncrypt(String content, String password) throws Exception, UnsupportedEncodingException {
//		return Byte2Hex(aesCrypt(Cipher.ENCRYPT_MODE,content.getBytes("utf-8"), Hex2Byte(password)));
//	}
//
//	/**
//	 * 解密收到的十六进制字符串
//	 *
//	 * @param content：十六进制字符串，使用前需要先进行hex2byte操作
//	 * @param password：十六进制key，使用前需要先进行hex2byte操作
//	 * @return 解密后的明文字符串（UTF-8编码）
//	 * @throws Exception
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesDecrypt(String content, String password) throws Exception, UnsupportedEncodingException {
//		byte[] buffer = aesCrypt(Cipher.DECRYPT_MODE,Hex2Byte(content), Hex2Byte(password));
//		String result = new String(buffer, "utf-8");
//		return result;
//	}
//
//	/**
//	 * AES加密/解密
//	 *
//	 * @param content
//	 *            需要 加密/解密 的内容
//	 * @param password
//	 *            加密/解密 密钥
//	 * @return
//	 */
//	public static byte[] aesCrypt1(int mode, byte[] content, byte[] password) {
//		try {
//			KeyGenerator kgen = KeyGenerator.getInstance("AES");
//			kgen.init(128, new SecureRandom(password));
//			SecretKey secretKey = kgen.generateKey();
//			byte[] enCodeFormat = secretKey.getEncoded();
//			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
//			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
//			cipher.init(mode, key);// 初始化
//			byte[] result = cipher.doFinal(content);// 加密/解密
//			return result;
//		} catch (NoSuchAlgorithmException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (InvalidKeyException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 加密
//	 * @param content：待加密内容，普通字符串
//	 * @param password：十六进制key，使用前需要先进行hex2byte操作
//	 * @return 加密后的内容，进行byte2hex后的内容
//	 * @throws Exception
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesEncrypt1(String content, String password) throws Exception, UnsupportedEncodingException {
//		return Byte2Hex(aesCrypt1(Cipher.ENCRYPT_MODE,content.getBytes("utf-8"), Hex2Byte(password)));
//	}
//
//	/**
//	 * 解密收到的十六进制字符串
//	 *
//	 * @param content：十六进制字符串，使用前需要先进行hex2byte操作
//	 * @param password：十六进制key，使用前需要先进行hex2byte操作
//	 * @return 解密后的明文字符串（UTF-8编码）
//	 * @throws Exception
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesDecrypt1(String content, String password) throws Exception, UnsupportedEncodingException {
//		byte[] buffer = aesCrypt1(Cipher.DECRYPT_MODE,Hex2Byte(content), Hex2Byte(password));
//		String result = new String(buffer, "utf-8");
//		return result;
//	}
//
//	/**
//	 * 加密/解密
//	 *
//	 * @param content
//	 *            需要 加密/解密 的内容
//	 * @param password
//	 *            加密/解密 密钥 这种加密方式有两种限制：1、
//	 *            密钥必须是16位的；2、待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出异常
//	 *            要解决如上异常，可以通过补全传入加密内容等方式进行避免
//	 * @return
//	 */
//	public static byte[] aesCrypt2(int mode, byte[] content, byte[] password) {
//		try {
//			SecretKeySpec key = new SecretKeySpec(password, "AES");
//			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");// 创建密码器
//			cipher.init(mode, key);// 初始化
//			byte[] result = cipher.doFinal(content);// 加密/解密
//			return result;
//		} catch (NoSuchAlgorithmException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (InvalidKeyException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 加密
//	 * @param content：待加密内容，普通字符串
//	 * @param password：十六进制password，使用前需要先进行hex2byte操作
//	 * @return 加密后的内容，进行byte2hex后的内容 这种加密方式有两种限制：1、
//	 *         密钥必须是16位的；2、待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出异常
//	 *         要解决如上异常，可以通过补全传入加密内容等方式进行避免
//	 * @throws Exception
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesEncrypt2(String content, String password) throws Exception, UnsupportedEncodingException {
//		return Byte2Hex(aesCrypt2(Cipher.ENCRYPT_MODE,content.getBytes("utf-8"), Hex2Byte(password)));
//	}
//
//	/**
//	 * 解密收到的十六进制字符串
//	 *
//	 * @param content：十六进制字符串，使用前需要先进行hex2byte操作
//	 * @param password：十六进制password，使用前需要先进行hex2byte操作
//	 * @return 解密后的明文字符串（UTF-8编码） 这种加密方式有两种限制：1、
//	 *         密钥必须是16位的；2、待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出异常
//	 *         要解决如上异常，可以通过补全传入加密内容等方式进行避免
//	 * @throws Exception
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesDecrypt2(String content, String password) throws Exception, UnsupportedEncodingException {
//		byte[] buffer = aesCrypt2(Cipher.DECRYPT_MODE,Hex2Byte(content), Hex2Byte(password));
//		String result = new String(buffer, "utf-8");
//		return result;
//	}
//
//	/**
//	 * 加密/解密
//	 *
//	 * @param content
//	 *            需要 加密/解密 的内容
//	 * @param password
//	 *            加密/解密 密钥 这种加密方式有两种限制：1、
//	 *            密钥必须是16位的；2、待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出异常
//	 *            要解决如上异常，可以通过补全传入加密内容等方式进行避免
//	 * @return
//	 */
//	public static byte[] aesCrypt3(int mode, byte[] content, byte[] password) {
//		try {
////			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
////			KeyGenerator kgen = KeyGenerator.getInstance("AES");
////			kgen.init(128, new SecureRandom(password));
////			SecretKey secretKey = kgen.generateKey();
////			byte[] enCodeFormat = secretKey.getEncoded();
////			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
//			SecretKeySpec key = new SecretKeySpec(password, "AES");
////			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
////			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");// 创建密码器
////			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");// 创建密码器
//			cipher.init(mode, key);// 初始化
//			byte[] result = cipher.doFinal(content);// 加密/解密
//			return result;
//		} catch (NoSuchAlgorithmException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (InvalidKeyException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 加密
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesEncrypt3(String content, String password) throws UnsupportedEncodingException{
//		return Byte2Hex(aesCrypt3(Cipher.ENCRYPT_MODE,content.getBytes("utf-8"), password.getBytes("utf-8")));
////		return new String(aesEncrypt3(content.getBytes("utf-8"), password.getBytes("utf-8")), "utf-8");
//	}
//
//	/**
//	 * 解密
//	 * @throws UnsupportedEncodingException
//	 */
//	public static String aesDecrypt3(String content, String password) throws UnsupportedEncodingException{
//		return new String(aesCrypt3(Cipher.DECRYPT_MODE,content.getBytes("utf-8"), password.getBytes("utf-8")), "utf-8");
//	}
//
//	/**
//	 * DES加密/解密
//	 *
//	 * @param mode
//	 *            模式:1加密，2解密
//	 * @param src
//	 *            数据
//	 * @param password
//	 *            密钥
//	 * @return
//	 */
//	public static byte[] desCrypt(int mode, byte[] src, byte[] password) {
//		try {
//			SecureRandom random = new SecureRandom();
//			DESKeySpec desKey = new DESKeySpec(password);
//			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//			SecretKey securekey = keyFactory.generateSecret(desKey);
//			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//			cipher.init(mode, securekey, random);
//			return cipher.doFinal(src);
//		} catch (Exception e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * DES加密
//	 *
//	 * @param content
//	 *            需要加密的内容
//	 * @param password
//	 *            加密密钥
//	 * @return
//	 */
//	public static byte[] desEncrypt(byte[] content, byte[] password) {
//		return desCrypt(Cipher.ENCRYPT_MODE, content, password);
//	}
//
//	/**
//	 * DES解密
//	 *
//	 * @param content
//	 *            待解密内容
//	 * @param password
//	 *            解密密钥
//	 * @return
//	 */
//	public static byte[] desDecrypt(byte[] content, byte[] password) {
//		return desCrypt(Cipher.DECRYPT_MODE, content, password);
//	}
//
//	/**
//	 * HMAC_SHA1加密
//	 *
//	 * @param src
//	 *            数据
//	 * @param password
//	 *            密钥
//	 * @return
//	 */
//	public static byte[] signHMAC_SHA1(byte[] src, byte[] password) {
//		try {
//			SecretKey key = new SecretKeySpec(password, "HmacSHA1");
//			Mac mac = Mac.getInstance("HmacSHA1");// 创建密码器
//			mac.init(key);// 初始化
//			return mac.doFinal(src);// 加密
//		} catch (Exception e) {
//			logger.warn(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * base64编码
//	 *
//	 * @param content
//	 *            需要编码的内容
//	 * @return
//	 */
//	public static String base64Encode(byte[] content) {
//		return new String(org.apache.commons.codec.binary.Base64.encodeBase64(content));
//	}
//
//	/**
//	 * base64解码
//	 *
//	 * @param content
//	 *            待解码内容
//	 * @return
//	 */
//	public static byte[] base64Decode(String content) {
//		return org.apache.commons.codec.binary.Base64.decodeBase64(content.getBytes());
//	}
//
//	public static String convertToMd5(String str) {
//		try {
//			byte newByte1[] = str.getBytes("utf-8");
//			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
//			byte newByte2[] = messagedigest.digest(newByte1);
//			StringBuffer sb = new StringBuffer();
//			for (int i = 0; i < newByte2.length; i++) {
//				String temp = Integer.toHexString(newByte2[i] & 0x000000ff);
//				if (temp.length() < 2)
//					sb.append("0");
//				sb.append(temp);
//			}
//			String cryptograph = sb.toString();
//			return cryptograph;
//		} catch (Exception e) {
//			logger.warn(e.getMessage());
//			return "error";
//		}
//	}
//
//	// 对于密码MD5值的说明：在对密码做MD5前，由于历史原因，需要对密码明文中的反斜线单引号进行转义，对于MD5出的值需要做一些处理，详见MD5和转义代码
//	// 对origin中存在的特殊字符special[]进行预处理
//	public static String jchange(String origin) {
//		try {
//			String sb = "";
//			int pos;
//			String special[] = { "\\", "'" };
//			for (int i = 0; i < special.length; i++) {
//				while (origin.indexOf(special[i]) != -1) { // 存在特殊字符串
//					pos = origin.indexOf(special[i]); // get 特殊字符串的索引
//					sb += origin.substring(0, pos) + "\\" + special[i]; // sb
//					origin = origin.substring(pos + 1);
//				}
//				origin = sb + origin;
//				sb = "";
//			}
//			return origin;
//
//		} catch (Exception e) {
//			logger.warn(e.getMessage());
//			return origin;
//		}
//	}
//
//	public static String convertToMd5ByUrs(String str) {
//		try {
//			str = jchange(str);
//			byte newByte1[] = str.getBytes();
//			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
//			byte newByte2[] = messagedigest.digest(newByte1);
//			StringBuffer sb = new StringBuffer();
//			for (int i = 0; i < newByte2.length; i++) {
//				String temp = Integer.toHexString(newByte2[i] & 0x000000ff);
//				if (temp.length() < 2)
//					sb.append("0");
//				sb.append(temp);
//			}
//			String cryptograph = sb.toString();
//			return cryptograph;
//		} catch (Exception e) {
//			logger.warn(e.getMessage());
//			return "error";
//		}
//	}
//
//	// public static String genProductKey(String product) {
//	// String keySource = product + System.nanoTime() + new Random().nextInt();
//	// return convertToMd5(keySource);
//	// }
//
//	public static String toUrlParam(Map<String, String> paras) {
//		String content = "";
//		if (paras == null || paras.isEmpty())
//			return content;
//		// for (Map.Entry<String, String> entry : paras.entrySet())
//		// content += "&" + entry.getKey() + "%3D" + entry.getValue();
//		for (String key : paras.keySet())
//			content += "&" + key + "%3D" + paras.get(key);
//		return content.substring(1);
//	}
//
//	public static Map<String, String> toParam(String content) {
//		Map<String, String> paras = new HashMap<String, String>();
//		if (content == null || content.isEmpty())
//			return paras;
//		String[] items = content.split("&");
//		for (String item : items) {
//			String[] temp = item.split("=");
//			if (temp.length != 2)
//				continue;
//			paras.put(temp[0], temp[1]);
//		}
//		return paras;
//	}
//
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		String key = "test";
//
//		String baseStr = "北京";
//		String res = "gBw4cHnGbJIbAUqAMI2x3w==";
//
//		String baseStr1 = "tobybaggio@163.com";
//		String res1 = "wJYIkiWlmtxJYjI/MXUowSRzyRA8CtDLLiQgSCikxRE=";
//
//		String key2 = Constants.secretkey;
//		String ts = "1471070364";
//		String devId = "E7B0A6DD-BBA6-46D4-AAD5-909B9A7E1984";
//		String res2 = "7CkkTt24QkfOXZjeW9hFuJEefhfFejdwzpSXNXHbxUtMJIJLLTgAfxY34PN6/6UE";
//		try {
////			String rest=base64Encode(CryptUtil.aesCrypt3(Cipher.ENCRYPT_MODE, baseStr.getBytes("utf-8"), key.getBytes("utf-8")));
//////			String bs64str=base64Encode(baseStr.getBytes("utf-8"));
//////			String rest = CryptUtil.aesEncrypt3(bs64str, key);
//////			String rest = new String(CryptUtil.aesEncrypt1(baseStr.getBytes(), key.getBytes()));
////			System.out.println(rest);
////			System.out.println(rest.equals(res));
//
////			String rest01=new String(CryptUtil.aesCrypt3(Cipher.DECRYPT_MODE,base64Decode(rest), key.getBytes("utf-8")),"utf-8");
////			System.out.println(rest01);
////			System.out.println(rest01.equals(baseStr));
//
////			String rest1=base64Encode(CryptUtil.aesCrypt3(Cipher.ENCRYPT_MODE, baseStr.getBytes("utf-8"), key.getBytes("utf-8")));
//////			String rest1 = new String(CryptUtil.aesEncrypt1(baseStr1.getBytes(), key.getBytes()));
////			System.out.println(rest1);
////			System.out.println(rest1.equals(res1));
//
////			String rest11=new String(CryptUtil.aesCrypt3(Cipher.DECRYPT_MODE,base64Decode(rest1), key.getBytes("utf-8")),"utf-8");
////			System.out.println(rest11);
////			System.out.println(rest11.equals(baseStr));
//
////			byte[] resbyte=base64Decode(res2);
////			for(int i=0;i<resbyte.length;i++){
////				System.out.printf("%x",resbyte[i]);
////			}
////			System.out.println();
////			String rest21=new String(CryptUtil.aesCrypt3(Cipher.DECRYPT_MODE,base64Decode(res2), hex2byte(key2)),"utf-8");
//			String rest21=new String(CryptUtil.aesCrypt3(Cipher.DECRYPT_MODE,base64Decode("WWU3Uf5OaAa7DV9xwsioiAs78vmJ48bV/KpeKoIBVOt48ErR02zJ6/KXOnxX046I"), key2.getBytes("utf-8")),"utf-8");
//			System.out.println(rest21);
////			System.out.println(rest11.equals(baseStr1));
//
//			String md5str=CryptUtil.convertToMd5(devId+ts);
////			String rest21=base64Encode(CryptUtil.aesCrypt3(Cipher.ENCRYPT_MODE,md5str.getBytes("utf-8"), key2.getBytes("utf-8")));
////			System.out.println(rest21);
//			System.out.println(rest21.equals(md5str));
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			e.printStackTrace();
//		}
//
////		String baseStr = "target=3&access_token=2.00Jc1vmBg_UzSD72af61b2b7f43trC&refresh_token=";
////		String key = "be5d54da0d14b76121f9bbf6668a1b1f";
////		String res = "OhFXg2fxrjs1srItnU1zTT1Ex25jUjLjshL/H/OCOfX0ZWYBl9V9Lhk8QGc2Rhzfm+8DuArZs1LfD74hUQ30gJPvwZYPV6U1oYS8+8kX/JM=";
////		try {
////			String rest = CryptUtil.aesEncrypt(baseStr, key);
////			System.out.println(rest);
////			System.out.println(rest.equals(res));
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//
//		// String pwd="123hotcoffee";
//		// String md5="c51ffa4bfe4e5b0af682dbe187af581c";
//		// System.out.println(CryptUtil.convertToMd5ByUrs(pwd).equals(md5));
//
//		// String Const_Key="HOTAPI";
//		// String token="8f0e2fcd75abffe324121e53fc03c5f8";
//		// Map<String, String> params=new HashMap<String,String>();
//		// params.put("id", "862");
//		//// params.put("reason", "垃圾广告！");
//		// log.debug("params.length="+params.size());
//		// log.debug("params="+JSON.toJSONString(params));
//		//
//		// Map<String, String> paras=new TreeMap<String,String>();
//		// paras.putAll(params);
//		//
//		// String keyString=token+Const_Key;
//		// String key=CryptUtil.base64Encode(keyString.getBytes("utf-8"));
//		// log.debug("keyString="+keyString);
//		// log.debug("keyString.length="+keyString.length());
//		// log.debug("key="+key);
//		// log.debug("key.length="+key.length());
//		//
//		// String baseString=CryptUtil.toUrlParam(paras);
//		// String base=CryptUtil.base64Encode(baseString.getBytes("UTF-8"));
//		// log.debug("baseString="+baseString);
//		// log.debug("baseString.length="+baseString.length());
//		// log.debug("base="+base);
//		// log.debug("base.length="+base.length());
//		//
//		// String
//		// signString=CryptUtil.base64Encode(CryptUtil.signHMAC_SHA1(base.getBytes("UTF-8"),
//		// key.getBytes("UTF-8")));
//		//// String
//		// signString=CryptUtil.Byte2Hex(CryptUtil.signHMAC_SHA1(base.getBytes("UTF-8"),
//		// key.getBytes("UTF-8")));
//		//// String
//		// sign=CryptUtil.base64Encode(signString.toLowerCase().getBytes("UTF-8"));
//		// log.debug("signString="+signString);
//		// log.debug("signString.length="+signString.length());
//		//// log.debug("sign="+sign);
//		//// log.debug("sign.length="+sign.length());
//		// log.debug(signString.equalsIgnoreCase("cff3ed41c41664bdea581c55534321151a68bcb7"));
//		//// log.debug(sign.equalsIgnoreCase("Y2ZmM2VkNDFjNDE2NjRiZGVhNTgxYzU1NTM0MzIxMTUxYTY4YmNiNw=="));
//	}
//}
