package cn.itcast.demo03;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * �ͻ����ϴ�ͼƬ�������������������յ�ͼƬ�Ͱ�ͼƬ���浽����
 * */
public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",8000);
		//��ȡ�ֽ��������׼����ͼƬ�͵�������ȥ
		OutputStream os = socket.getOutputStream();
		//�����ֽ�����������ȡ����������ԴͼƬ
		FileInputStream fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\��.jpg");
	    byte[] picturedata = new byte[1024];
	    int len = 0;
		while((len = fis.read(picturedata)) != -1){
			//fis.read(picturedata)�����fis�ļ������󣬰����ݴ浽picturedata�����в�����ռ������ĳ���
			os.write(picturedata, 0, len);//��picturedata�����е�����д��������
		}
		
		//��������д��ֹ����,���߷������Ѿ�д����,��Ҫ�ٵȴ���
		socket.shutdownOutput();
		
		
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		
		int len1 = is.read(data);
		System.out.println(new String(data,0,len1));
	}
}
