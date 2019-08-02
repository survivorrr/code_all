package cn.itcast.Thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Upload implements Runnable{
	private Socket socket;
	public Upload(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try{
		InputStream is = socket.getInputStream();
		
		//��Ŀ�ĵ��ļ��з�װ��File����
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\shu");
		if(!file.exists()){//�����C:\\Users\\Justzh_liao\\Desktop���Ҳ���shu����ļ��У��ʹ���һ��
			file.mkdirs();
		}
		//����һ���ַ������������ַ���
		String name = "itcast"+System.currentTimeMillis()+new Random().nextInt(1000)+".jpg";
		
		FileOutputStream fos = new FileOutputStream(file+file.separator+name);// file.separator�൱�ڡ�\\��
		byte[] data = new byte[1024];
		int len = 0;
		while((len = is.read(data))!=-1){//����is�ǿͻ��˵��ֽ����飬������-1������read��һֱ�ȴ�
			fos.write(data,0,len);
		}
		
		OutputStream os = socket.getOutputStream();
		os.write("�ϴ��ɹ���".getBytes());
		socket.close();
		fos.close();
        //os,is����Ҫ�أ���Ϊsocket������
		}catch(Exception ex){}
	}
}
