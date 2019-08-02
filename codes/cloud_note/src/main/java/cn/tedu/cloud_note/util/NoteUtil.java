package cn.tedu.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	public static String md5(String src){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] output = md.digest(src.getBytes());
			String s = Base64.encodeBase64String(output);
			return s;
		}catch(Exception e) {
			throw new NoteException("密码加密失败",e);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(md5("123456"));
//		System.out.println(md5("12354654676dfdfdfdf"));
		System.out.println(createId());
		System.out.println(createId());
	}
	//update cn_user set cn_user_password='4QrcOUm6Wau+VuBX8g+IPg=='
	
}
