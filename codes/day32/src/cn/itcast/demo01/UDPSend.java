package cn.itcast.demo01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Scanner;

public class UDPSend {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress inet = InetAddress.getByName("127.0.0.1");//����ǲ�Ҫ��getLocalHost(),��Ϊ�����͹̶�סip��ַ��
		while(true){
			String message = sc.nextLine();
			byte[] bytes = message.getBytes();
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inet, 5000);
			ds.send(dp);
		}
		
//		ds.close();
		
	}
}
