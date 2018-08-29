package com.dyt02.element;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

//英雄坦克
public class HeroTank {
	//成员变量
	
	//坐标位置
	public int x,y;
	//方向
	public int direct;
	//坦克移动速度
	public int speed=4;
	//判断我方坦克存活
	public boolean isLive=true;
	//图片
	Image []images = new Image[4];
	//构造方法
	public HeroTank(int x, int y, int direct) {
		super();
		try {
			for(int i=0;i<4;i++){
				File input = new File("src/image/hero"+(i+1)+".gif");
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

}
	
	
	
