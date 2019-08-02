package cn.itcast.demo02;
/*
 * 客户端向服务器发送数据，当服务器收到数据时，服务器输出“发送数据到服务器”
 * */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = new ServerSocket(6000);//传递端口号
		Socket socket = serversocket.accept();//调用服务器套接字对象中方法accept获取客户端的套接字
		InputStream is = socket.getInputStream();//通过客户端套接字对象socket,获取字节输入流
		byte[] data = new byte[1024];
		int len = is.read(data);//把读出来的数据传到data数组，并返回数据在数组中的长度
		System.out.println(new String(data,0,len));//从0到len读取数组中的数据
		
		//使用客户端的套接字socket，向客户端反馈信息
		OutputStream os = socket.getOutputStream();
		os.write("收到谢谢！".getBytes());
		socket.close();
		serversocket.close();
	}
}
