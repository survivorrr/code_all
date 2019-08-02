package com.tarena.shoot;

import java.util.Random;

public class Bullet extends FlyingObject {
	private int speed = 3;
	
	public Bullet(int x,int y){
		image = shootGame.bullet;
		width = image.getWidth();
		height = image.getHeight(); 
		this.x = x;
		this.y = y;
	}
//	public Bullet(){}
	
	public void step(){
			y-=speed;
	}
	
	public boolean outOfBounds(){
		return this.y<=-this.height;
	}
}
