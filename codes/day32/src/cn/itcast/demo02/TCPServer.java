package cn.itcast.demo02;
/*
 * �ͻ�����������������ݣ����������յ�����ʱ��������������������ݵ���������
 * */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = new ServerSocket(6000);//���ݶ˿ں�
		Socket socket = serversocket.accept();//���÷������׽��ֶ����з���accept��ȡ�ͻ��˵��׽���
		InputStream is = socket.getInputStream();//ͨ���ͻ����׽��ֶ���socket,��ȡ�ֽ�������
		byte[] data = new byte[1024];
		int len = is.read(data);//�Ѷ����������ݴ���data���飬�����������������еĳ���
		System.out.println(new String(data,0,len));//��0��len��ȡ�����е�����
		
		//ʹ�ÿͻ��˵��׽���socket����ͻ��˷�����Ϣ
		OutputStream os = socket.getOutputStream();
		os.write("�յ�лл��".getBytes());
		socket.close();
		serversocket.close();
	}
}
