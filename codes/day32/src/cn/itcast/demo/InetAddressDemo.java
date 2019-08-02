package cn.itcast.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();//输出结果就是主机名
		System.out.println(inet);
		
		String ip = inet.getHostAddress();
		String name = inet.getHostName();
		System.out.println(ip+" "+name);
/*		String host = inet.toString();
		String[] str = host.split("/");//切割字符串
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}*/
	}
}
