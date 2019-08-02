package com.tarena.shoot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class shootGame extends JPanel{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654; 
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	public int state = START;
	
	private Hero hero = new Hero();
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};
	
/*	public shootGame(){
		flyings = new FlyingObject[2];
		flyings[0] = new Airplane(); 
		flyings[1] = new Bee();
		bullets = new Bullet[1];
		bullets[0] = new Bullet(100,200);
	}*/
	
	static{
		try{
			background = ImageIO.read(shootGame.class.getResource("background.png"));
			start = ImageIO.read(shootGame.class.getResource("start.png"));
			pause = ImageIO.read(shootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(shootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(shootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(shootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(shootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(shootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(shootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public FlyingObject nextOne(){//判断下一个飞行物是小蜜蜂还是敌机
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type < 4){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0;
	                             //敌人(敌机+小蜜蜂)入场
	public void enterAction(){
		flyEnteredIndex++;
		if(flyEnteredIndex%40==0){//每400ms生成一个敌人
			FlyingObject one= nextOne();
			flyings = Arrays.copyOf(flyings,flyings.length+1);
			flyings[flyings.length-1] = one;
		}
	}
	
	public void stepAction(){//飞行物(小蜜蜂+小敌机)，子弹走步
		hero.step();
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
	}
	
	int shootIndex = 0;
	public void shootAction(){//发射子弹
		shootIndex ++;
		if(shootIndex%30==0){//每300ms发射一颗子弹
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);//数组扩容
/*			if(bs.length>1){
				bullets[bullets.length-1] = bs[0];
				bullets[bullets.length-2] = bs[1];
			}else{
				bullets[bullets.length-1] = bs[0];
			}*/
			System.arraycopy(bs, 0, bullets,bullets.length-bs.length, bs.length);//数组的追加
			
		}
	}
	
	public void outOfBoundsAction(){//越界
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			if(!f.outOfBounds()){//若不越界
				flyingLives[index] = f;
				index++;
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//不越界的小蜜蜂或敌机放进数组中
		
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			if(!b.outOfBounds()){
				bulletLives[index] = b;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletLives,index);//不越界的子弹放进数组中
	}
	
	public void bangAction(){   
		 for(int i=0;i<bullets.length;i++){
			 Bullet b = bullets[i];
			 bang(b);  //子弹与敌人碰撞
		 }
	}
	
	int score = 0;
	int life = 3;
	public void bang(Bullet b){
		int index = -1;
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			if(f.shootby(b)){
				index = i;
				break;
			}
		}
		if(index!=-1){
			FlyingObject one = flyings[index];
			if(one instanceof Enemy){
				Enemy e = (Enemy) one;
				score += e.getScore();
			}
			if(one instanceof Award){
				Award a = (Award) one;
				int type = a.getType();
				switch(type){
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length-1);//数组缩容
		}
	}
	
	public void checkGameOverAction(){
		if(isGameOver()){
			state = GAME_OVER;
		}
	}
	
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			if(hero.hit(f)){
				hero.subtractLife();
				hero.clearDoubleFire();
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		 return hero.getLife()<=0;
	}
	
	public void action(){
		MouseAdapter l = new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
				}
			}
			public void mouseClicked(MouseEvent e){
				switch(state){
				case START:
					state = RUNNING;
					break;
				case GAME_OVER:
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){
					state = PAUSE;
				}
			}
			public void mouseEntered(MouseEvent e){
				if(state==PAUSE){
				state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);//处理鼠标操作事件
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		
		Timer timer = new Timer();
		int intervel = 10;//时间间隔(以毫秒为单位)
		timer.schedule(new TimerTask(){
			public void run(){
				if(state==RUNNING){
					enterAction();//敌人(敌机+小蜜蜂)入场
					stepAction();
					shootAction();
					outOfBoundsAction();
					bangAction();
					checkGameOverAction();		
				}
				repaint();
			}
		},intervel,intervel);
	
	}
	
	public void paint(Graphics g){
		g.drawImage(background,0,0,null);
		paintHero(g);
		paintFlyingObjects(g);
		paintBullets(g);
		paintScoreAndLife(g);
		paintState(g);
	}
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);//hero.image也可以换成shootGame.hero0程序不出错
	}
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			g.drawImage(b.image,b.x,b.y,null);
		}
	//	g.drawImage(bullets[0].image,bullets[0].x,bullets[0].y,null);
	}
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xFF0000));//RGB三原色
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		g.drawString("SCORE:"+score,10,25);
		g.drawString("LIFE:"+hero.getLife(), 10, 45);
	}
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER:
			g.drawImage(gameover,0,0,null);
		break;
		}	
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("日常打ll");
		shootGame game = new shootGame();
		frame.add(game);
		frame.setSize(WIDTH,HEIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点×程序停止运行
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.action();
		
	}
}
