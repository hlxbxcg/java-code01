package com.dyt02.element;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

//Ӣ��̹��
public class HeroTank {
	//��Ա����
	
	//����λ��
	public int x,y;
	//����
	public int direct;
	//̹���ƶ��ٶ�
	public int speed=4;
	//�ж��ҷ�̹�˴��
	public boolean isLive=true;
	//ͼƬ
	Image []images = new Image[4];
	//���췽��
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
	
	//��Ա����
	public void drawSelf(Graphics g){
		switch (direct) {
		case 1://�����Σ�����
			g.drawImage(images[0],x,y,30,30,null);
			break;
		case 2://�����Σ�����
			g.drawImage(images[1],x,y,30,30,null);
			break;
		case 3://�����Σ�����
			g.drawImage(images[2],x,y,30,30,null);
			break;
		case 4://�����Σ�����
			g.drawImage(images[3],x,y,30,30,null);
			break;
		}
	}

}
	
	
	
