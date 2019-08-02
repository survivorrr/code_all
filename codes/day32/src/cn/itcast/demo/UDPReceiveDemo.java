package cn.itcast.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo {
	public static void main(String[] args) throws IOException{
		DatagramSocket ds = new DatagramSocket(5000);
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data, data.length);
		ds.receive(dp);
		String ip = dp.getAddress().getHostAddress();
		int length = dp.getLength();
		int port = dp.getPort();
		System.out.println(new String(data,0,length)+" "+ip+":"+port);
		ds.close();
	}
}
