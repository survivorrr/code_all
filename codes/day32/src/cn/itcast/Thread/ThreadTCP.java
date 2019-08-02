
package cn.itcast.Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadTCP {
	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = new ServerSocket(8000);
		while(true){
			//获取到一个客户端，必须开启一个新线程
			Socket socket = serversocket.accept();
			Upload upload = new Upload(socket);
			Thread t = new Thread(upload);
			t.start();
			
	//		new Thread(new Upload(socket)).start();
		}
	}
}
