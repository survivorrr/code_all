
package cn.itcast.Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadTCP {
	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = new ServerSocket(8000);
		while(true){
			//��ȡ��һ���ͻ��ˣ����뿪��һ�����߳�
			Socket socket = serversocket.accept();
			Upload upload = new Upload(socket);
			Thread t = new Thread(upload);
			t.start();
			
	//		new Thread(new Upload(socket)).start();
		}
	}
}
