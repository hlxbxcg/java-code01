package com.dyt02.element;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

//英雄坦克
public class EnemyTank implements Runnable{
	//成员变量
	//坐标位置
	public int x,y;
	//方向
	public int direct;
	//坦克移动速度
	public int speed=2;
	//创建敌方坦克子弹类
	public CopyOnWriteArrayList<Bullet> etbs = new CopyOnWriteArrayList<Bullet>();
	public Bullet b;
	//判断敌方坦克存活
	public boolean isLive=true;
	//计数器
	int time=0;
	//录入图片
	Image []images = new Image[8];
	//构造方法
	public EnemyTank(int x, int y, int direct) {
		super();
		try {
			for(int i=0;i<4;i++){
				File input = new File("src/image/et"+(i+1)+".gif");
				images[i]=ImageIO.read(input);
			}
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
		case 1://丁云涛：向上
			g.drawImage(images[0],x,y,30,30,null);
			break;
		case 2://丁云涛：向下
			g.drawImage(images[1],x,y,30,30,null);
			break;
		case 3://丁云涛：向左
			g.drawImage(images[2],x,y,30,30,null);
			break;
		case 4://丁云涛：向右
			g.drawImage(images[3],x,y,30,30,null);
			break;
		}
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
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
	 * 
	 * 敌人坦克逻辑判断
	 * 
	 */
	
	public void logic(){
		if(y>=340){
			direct =1;
		}
		if(y<0){
			direct =2;
		}
		if(x>=450){
			direct =3;
		}
		if(x<0){
			direct =4;
		}
		
		time++;
		if(time%20==0){
			switch (direct) {
			case 1:
				b=new Bullet(x,y-3,direct);
				Thread t1 = new Thread(b);
				t1.start();
				etbs.add(b);
				break;
			case 2:
				b=new Bullet(x,y,direct);
				Thread t2 = new Thread(b);
				t2.start();
				etbs.add(b);
				break;
			case 3:
				b=new Bullet(x,y-4,direct);
				Thread t3 = new Thread(b);
				t3.start();
				etbs.add(b);
				break;
			case 4:
				b=new Bullet(x+5,y-4,direct);
				Thread t4 = new Thread(b);
				t4.start();
				etbs.add(b);
				break;
			
			}
		}
		if(time%50==0){
			//Java中产生随机数的类
//			Random r = new Random();
			//nextInt(n)方法会产生0到n-1范围内之间的随机数
			//（数据类型）（最小值+Math.random()*(最大值-最小值+1)）此方法不用定义Random
			//例(int)(1+Math.random()*(10-1+1))
			int m=(int)(1+Math.random()*(4-1+1));
			direct=m;
		}
	}	
}

