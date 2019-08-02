package cn.tedu.web;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller
@Scope("prototype")
public class PhotoAction {
	private InputStream photo;
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public String execute() throws IOException {
		BufferedImage img = new BufferedImage(400,300,BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(0, 0, 0xffff00);
////////////////////////////////////////////////////////////////////////////		
		for(int i=0;i<1000;i++) {
			int x=(int)(Math.random()*img.getWidth());
			int y=(int)(Math.random()*img.getHeight());
			int c=(int)(Math.random()*0xffffff);
			img.setRGB(x, y, c);
		}
		//��һ����Ϊ����ͼƬ����һ����Ȥ�ļ��㷨����ͼƬ���ÿ�
		Graphics2D g = img.createGraphics();
		g.setColor(Color.CYAN);
		g.drawString("���ǻ���", 200, 150);
//////////////////////////////////////////////////////////////////////////////////		
		//����Ƭ����Ϊpng��ʽ������
		ByteArrayOutputStream out = new ByteArrayOutputStream();//����һ�����������
		ImageIO.write(img, "png", out);//����Ƭ����png��ʽ���������
		out.close();
		byte[] png = out.toByteArray();
		//�������װΪInputSream
		photo = new ByteArrayInputStream(png);
		return "success";
	}
}
