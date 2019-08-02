package cn.itcast.demo02;
/*
 * 客户端向服务器发送数据，当服务器收到数据时，返回“收到谢谢”
 * */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("127.0.0.1",6000);//传递IP地址和端口号
		OutputStream os = socket.getOutputStream();
		os.write("发送数据给服务器".getBytes());
		
		//通过套接字socket接收服务器端发出的反馈信息
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = is.read(data);
		System.out.println(new String(data,0,len));
		
		socket.close();
	}
}
