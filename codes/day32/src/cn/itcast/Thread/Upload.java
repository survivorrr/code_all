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
		
		//将目的的文件夹封装到File对象
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\shu");
		if(!file.exists()){//如果在C:\\Users\\Justzh_liao\\Desktop中找不到shu这个文件夹，就创建一个
			file.mkdirs();
		}
		//加了一个字符串就整体变成字符串
		String name = "itcast"+System.currentTimeMillis()+new Random().nextInt(1000)+".jpg";
		
		FileOutputStream fos = new FileOutputStream(file+file.separator+name);// file.separator相当于“\\”
		byte[] data = new byte[1024];
		int len = 0;
		while((len = is.read(data))!=-1){//都的is是客户端的字节数组，读不到-1，所以read会一直等待
			fos.write(data,0,len);
		}
		
		OutputStream os = socket.getOutputStream();
		os.write("上传成功！".getBytes());
		socket.close();
		fos.close();
        //os,is不需要关，因为socket都关了
		}catch(Exception ex){}
	}
}
