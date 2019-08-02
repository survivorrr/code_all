package com.tarena.shoot;

import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;
	
	public Airplane(){
		image = shootGame.airplane;
		width = image.getWidth();
		height = image.getHeight(); 
		Random rand = new Random();
		x = rand.nextInt(shootGame.WIDTH-this.width);
		y = -this.height;
//		y=200;
	}
	
	public int getScore(){
		return 5;
	}
	
	public void step(){
		y+=speed;
	}
	
	public boolean outOfBounds(){
		return this.y>=shootGame.HEIGHT;
	}
}
