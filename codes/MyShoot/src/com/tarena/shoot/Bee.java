package com.tarena.shoot;

import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;
	private int ySpeed = 2;
	private int awardType;
	
	public Bee(){
		image = shootGame.bee;
		width = image.getWidth();
		height = image.getHeight(); 
		Random rand = new Random();
		x = rand.nextInt(shootGame.WIDTH-this.width);
		y = -this.height;
//		y=200;
		awardType = rand.nextInt(2);
	}
	
	public int getType(){
		return awardType;
	}
	
	public void step(){
		x+=xSpeed;
		y+=ySpeed;
		if(x<=0){
			xSpeed = 1;
		}else if(x>=shootGame.WIDTH-this.width){
			xSpeed = -1;
		}
	}
	
	public boolean outOfBounds(){
		return this.y>=shootGame.HEIGHT;
	}
}
