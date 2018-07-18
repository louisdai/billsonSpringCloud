//import java.net.URLEncoder;
//
//import javax.crypto.Cipher;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class CryptService {
//    private Logger logger = LoggerFactory.getLogger(CryptService.class);
//
//	public String sign(String content){
//		if(content==null){
//			logger.warn("content:{}",content);
//			return null;
//		}
//		String md5str=CryptUtil.convertToMd5(content);
//		return encrypt(md5str);
//	}
//
//	public String encrypt(String content){
//		if(content==null){
//			logger.warn("content:{}",content);
//			return null;
//		}
//		try {
//			return CryptUtil.base64Encode(CryptUtil.aesCrypt3(Cipher.ENCRYPT_MODE,content.getBytes(Constants.charsetName), Constants.secretkey.getBytes(Constants.charsetName)));
//		} catch (Exception e) {
//			logger.warn("content:{},{}",content,e.getMessage());
//		}
//		return null;
//	}
//
//	public String decrypt(String content){
//		if(content==null){
//			logger.warn("content:{}",content);
//			return null;
//		}
//		try {
//			return new String(CryptUtil.aesCrypt3(Cipher.DECRYPT_MODE,CryptUtil.base64Decode(content), Constants.secretkey.getBytes(Constants.charsetName)),Constants.charsetName);
//		} catch (Exception e) {
//			logger.warn("content:{},{}",content,e.getMessage());
//		}
//		return null;
//	}
//
//	public String base64Encode(String content){
//		if(content==null){
//			logger.warn("content:{}",content);
//			return null;
//		}
//		try {
//			return CryptUtil.base64Encode(content.getBytes(Constants.charsetName));
//		} catch (Exception e) {
//			logger.warn("content:{},err:{}",content,e.getMessage());
//		}
//		return null;
//	}
//
//	public String base64Decode(String content){
//		if(content==null){
//			logger.warn("content:{}",content);
//			return null;
//		}
//		try {
//			return new String(CryptUtil.base64Decode(content),Constants.charsetName);
//		} catch (Exception e) {
//			logger.warn("content:{},err:{}",content,e.getMessage());
//		}
//		return null;
//	}
//
//	public String urlEncoder(String content){
//		if(content==null){
//			logger.warn("content:{}",content);
//			return null;
//		}
//		try {
//			String res=URLEncoder.encode(content,Constants.charsetName);
//			return res.replaceAll("\\+", "%20");
//		} catch (Exception e) {
//			logger.warn("content:{},err:{}",content,e.getMessage());
//		}
//		return null;
//	}
//}
