package cn.itcast.demo02;
/*
 * �ͻ�����������������ݣ����������յ�����ʱ�����ء��յ�лл��
 * */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("127.0.0.1",6000);//����IP��ַ�Ͷ˿ں�
		OutputStream os = socket.getOutputStream();
		os.write("�������ݸ�������".getBytes());
		
		//ͨ���׽���socket���շ������˷����ķ�����Ϣ
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = is.read(data);
		System.out.println(new String(data,0,len));
		
		socket.close();
	}
}
