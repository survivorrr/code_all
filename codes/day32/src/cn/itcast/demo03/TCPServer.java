package cn.itcast.demo03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serversocket = new ServerSocket(8000);
		Socket socket = serversocket.accept();
		InputStream is = socket.getInputStream();
		
		//将目的的文件夹封装到File对象
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\shu");
		if(!file.exists()){
			file.mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(file+"\\树1.jpg");
		byte[] data = new byte[1024];
		int len = 0;
		while((len = is.read(data))!=-1){//都的is是客户端的字节数组，读不到-1，所以read会一直等待
			fos.write(data,0,len);
		}
		
		OutputStream os = socket.getOutputStream();
		os.write("收到谢谢！".getBytes());
		socket.close();
		serversocket.close();
		fos.close();
        //os,is不需要关，因为socket都关了
	}
}
