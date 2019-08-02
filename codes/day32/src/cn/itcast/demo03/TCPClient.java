package cn.itcast.demo03;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 客户端上传图片给服务器，服务器接收到图片就把图片保存到电脑
 * */
public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",8000);
		//获取字节输出流，准备把图片送到服务器去
		OutputStream os = socket.getOutputStream();
		//创建字节输入流，读取本机的数据源图片
		FileInputStream fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\树.jpg");
	    byte[] picturedata = new byte[1024];
	    int len = 0;
		while((len = fis.read(picturedata)) != -1){
			//fis.read(picturedata)代表读fis文件流对象，把数据存到picturedata数组中并返回占用数组的长度
			os.write(picturedata, 0, len);//把picturedata数组中的数据写到服务器
		}
		
		//给服务器写终止序列,告诉服务器已经写完了,不要再等待了
		socket.shutdownOutput();
		
		
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		
		int len1 = is.read(data);
		System.out.println(new String(data,0,len1));
	}
}
