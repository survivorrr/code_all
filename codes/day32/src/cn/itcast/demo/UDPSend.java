package cn.itcast.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;

public class UDPSend {
	public static void main(String[] args) throws IOException {
		byte[] bytes = "���UDP".getBytes();
		InetAddress inet = InetAddress.getByName("127.0.0.1");//����ǲ�Ҫ��getLocalHost(),��Ϊ�����͹̶�סip��ַ��
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inet, 5000);
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
		
	}
}
