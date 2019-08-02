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
		//这一段是为了在图片上玩一下有趣的简单算法，让图片更好看
		Graphics2D g = img.createGraphics();
		g.setColor(Color.CYAN);
		g.drawString("这是画笔", 200, 150);
//////////////////////////////////////////////////////////////////////////////////		
		//将照片编码为png格式的数组
		ByteArrayOutputStream out = new ByteArrayOutputStream();//创建一个数组输出流
		ImageIO.write(img, "png", out);//把照片按照png格式放在输出流
		out.close();
		byte[] png = out.toByteArray();
		//将数组包装为InputSream
		photo = new ByteArrayInputStream(png);
		return "success";
	}
}
