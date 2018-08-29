package com.dyt02.element;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

//Ӣ��̹��
public class EnemyTank implements Runnable{
	//��Ա����
	//����λ��
	public int x,y;
	//����
	public int direct;
	//̹���ƶ��ٶ�
	public int speed=2;
	//�����з�̹���ӵ���
	public CopyOnWriteArrayList<Bullet> etbs = new CopyOnWriteArrayList<Bullet>();
	public Bullet b;
	//�жϵз�̹�˴��
	public boolean isLive=true;
	//������
	int time=0;
	//¼��ͼƬ
	Image []images = new Image[8];
	//���췽��
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
	 * ����̹���߼��ж�
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
			//Java�в������������
//			Random r = new Random();
			//nextInt(n)���������0��n-1��Χ��֮��������
			//���������ͣ�����Сֵ+Math.random()*(���ֵ-��Сֵ+1)���˷������ö���Random
			//��(int)(1+Math.random()*(10-1+1))
			int m=(int)(1+Math.random()*(4-1+1));
			direct=m;
		}
	}	
}

