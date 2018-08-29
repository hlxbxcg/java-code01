package com.dyt02.element;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

//英雄坦克
public class Bullet implements Runnable{
	//成员变量
	
	//坐标位置
	public int x,y;
	//方向
	public int direct;
	//坦克移动速度
	public int speed=6;
	//判断子弹线程终止
	public boolean isLive=true;
	//图片
	Image []images = new Image[1];
	//构造方法
	public Bullet(int x, int y, int direct) {
		super();
		try {
				File input = new File("src/image/bullet.gif");
				images[0]=ImageIO.read(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	
	//成员方法
	public void drawSelf(Graphics g){
		switch (direct) {
		case 1:
			g.drawImage(images[0],x+12,y,5,5,null);
			break;
		case 2:
			g.drawImage(images[0],x+12,y+30,5,5,null);
			break;
		case 3:
			g.drawImage(images[0],x,y+15,5,5,null);
			break;
		case 4:
			g.drawImage(images[0],x+20,y+15,5,5,null);
			break;
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isLive){
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (direct) {
			case 1:
				y-=speed;
				break;
			case 2:
				y+=speed;
				break;			
			case 3:
				x-=speed;
				break;			
			case 4:
				x+=speed;
				break;
			}
		}
	}
	/**
	 * 子弹逻辑判断方法
	 */
	public void logic(){
		if(x<0||x>500||y<0||y>400){
			isLive = false;
		}
	}
}
