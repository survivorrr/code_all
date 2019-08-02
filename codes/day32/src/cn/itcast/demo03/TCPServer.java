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
		
		//��Ŀ�ĵ��ļ��з�װ��File����
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\shu");
		if(!file.exists()){
			file.mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(file+"\\��1.jpg");
		byte[] data = new byte[1024];
		int len = 0;
		while((len = is.read(data))!=-1){//����is�ǿͻ��˵��ֽ����飬������-1������read��һֱ�ȴ�
			fos.write(data,0,len);
		}
		
		OutputStream os = socket.getOutputStream();
		os.write("�յ�лл��".getBytes());
		socket.close();
		serversocket.close();
		fos.close();
        //os,is����Ҫ�أ���Ϊsocket������
	}
}
