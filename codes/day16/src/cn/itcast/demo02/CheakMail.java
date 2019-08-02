package cn.itcast.demo02;

public class CheakMail {
	public static void main(String[] args) {
		cheakMail();
	}
	
	public static void cheakMail()
	{
		String mail = "Justzh_Liao@163.com";
		boolean a = mail.matches("[a-zA-Z0-9_]+@[0-9a-z]+(\\.[a-z]+)+");
		System.out.println(a);
	}
}
