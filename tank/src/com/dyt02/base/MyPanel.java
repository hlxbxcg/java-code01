package com.dyt02.base;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JPanel;

import com.dyt02.element.Blast;
import com.dyt02.element.Bullet;
import com.dyt02.element.EnemyTank;
import com.dyt02.element.HeroTank;
import com.dyt02.element.PlusEnemyTank;
import com.dyt02.element.SuperEnemyTank;
/**
 * 丁云涛：implements用于继承另一个特殊的类（KeyListener）跟键盘联系在一起
 * @author dyt
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel implements KeyListener,Runnable {

	int a=0;
	int n=4;
	int c=0;
	int q=1;
	//-----------定义一个计分板-------------
	Integer score=0;
	//--------定义一个英雄坦克的集合-----------
	HeroTank ht;
	//--------定义一个集合用于存放敌人的坦克----------
	CopyOnWriteArrayList<EnemyTank> ets = new CopyOnWriteArrayList<EnemyTank>();
	//-------定义一个集合用于存放加强版敌人的坦克---------
	CopyOnWriteArrayList<PlusEnemyTank> pets = new CopyOnWriteArrayList<PlusEnemyTank>();
	//-------定义一个集合用于存放超级版敌人的坦克----------
	CopyOnWriteArrayList<SuperEnemyTank> sets = new CopyOnWriteArrayList<SuperEnemyTank>();
	//---------定义一个集合用于存放英雄的子弹------------
	CopyOnWriteArrayList<Bullet> buls = new CopyOnWriteArrayList<Bullet>();
	//--------定义一个爆炸的集合-----------------
	CopyOnWriteArrayList<Blast> bls = new CopyOnWriteArrayList<Blast>();
	Bullet b;
	public MyPanel(){
		//-------------创建英雄的坦克--------------
		ht = new HeroTank(200, 280, 1);
		//-------------创建敌人的坦克--------------
		for(int i=0;i<n;i++){
			EnemyTank  et=new EnemyTank(50+i*100, 100,2);
			Thread t = new Thread(et);
			t.start();
			ets.add(et);
			}
}
	
	public void paint(Graphics g) {
		super.paint(g);
		//---------绘制面板为黑色----------
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 400);
		//----------绘制计分板-----------
		String scores = Integer.toString(score);
		g.setColor(Color.GREEN);
		g.setFont(new Font(scores,Font.BOLD, 25));
		g.drawString(scores,400,50);
		//---------绘制所有爆炸效果----------
		for(Blast bl:bls){
			bl.drawSelf(g);
		}
		//---------绘制英雄坦克-----------
		if(ht.isLive){
		ht.drawSelf(g);
		}
		//---------英雄坦克阵亡----------
		if(!ht.isLive){
			ht.x=-1000;
			ht.y=-1000;
		}
		//---------绘制敌人坦克----------
		if(score<40){
		for(EnemyTank et:ets){
			if(et.isLive)
			et.drawSelf(g);
			}
		}
		//-------------创建加强版敌人的坦克---------------
		if(score>=40&&score<120){		
		if(a==0){
		for(int j=0;j<n;j++){
				PlusEnemyTank  pet=new PlusEnemyTank(50+j*100, 100,2);
				Thread m = new Thread(pet);
				m.start();
				pets.add(pet);
				a++;
			}
		}
		//--------绘制敌方加强版坦克---------
		for(PlusEnemyTank pet : pets){
				if(pet.isLive){
					pet.drawSelf(g);
				}
			}
		}
		//-------------创建敌方超级坦克-----------------
		if(score>=120&&score<240){		
			if(c==0){
			for(int k=0;k<n;k++){
					SuperEnemyTank  set=new SuperEnemyTank(50+k*100, 100,2);
					Thread o = new Thread(set);
					o.start();
					sets.add(set);
					c++;
				}
			}
		//---------绘制敌方超级坦克-----------
		for(SuperEnemyTank set : sets){
			if(set.isLive){
				set.drawSelf(g);
			}
		}
	}
		//--------绘制英雄坦克子弹---------
		for(Bullet b:buls){
			if(b.isLive){
				if(b!=null){
					b.drawSelf(g);
				}
			}
			if(ht.isLive==false){
				buls.remove(b);
			}
		}
		//-----------绘制敌方坦克子弹------------
		for(EnemyTank et : ets){
			for(Bullet b : et.etbs)
				if(b.isLive){
				b.drawSelf(g);
				}
		}
			//---------绘制加强版敌方坦克子弹--------
			if(score>=40&&score<120){
				for(PlusEnemyTank pet : pets){
					for(Bullet b : pet.petbs)
						if(b.isLive){
							b.drawSelf(g);
						}
				}
			}
			//---------绘制超级敌人坦克子弹----------
			if(score>=120){
				for(SuperEnemyTank set : sets){
					for(Bullet b : set.setbs)
						if(b.isLive){
							b.drawSelf(g);
						}
				}
			}
			//-------------移除敌方坦克--------------
			for(EnemyTank et : ets){
				if(!et.isLive){
					Blast blast=new Blast(et.x+15, et.y+15);
					blast.drawSelf(g);
					ets.remove(et);
				}
			}
		}
	@Override
	//丁云涛：KeyPressed作用：当该键按下时进行的操作
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(ht.isLive){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP://丁云涛：向上
				ht.direct=1;
				if(ht.y>=5){
					ht.y-=ht.speed;
				}
				break;
			case KeyEvent.VK_DOWN://丁云涛：向下
				ht.direct=2;
				if(ht.y<=340){
				ht.y+=ht.speed;
				}
				break;
			case KeyEvent.VK_LEFT://丁云涛：向左
				ht.direct=3;
				if(ht.x>=5){
				ht.x-=ht.speed;
				}
				break;
			case KeyEvent.VK_RIGHT://丁云涛：向右
				ht.direct=4;
				if(ht.x<=450){
				ht.x+=ht.speed;
				}
				break;
			case KeyEvent.VK_SPACE:
				switch (ht.direct) {
				case 1:
					b=new Bullet(ht.x,ht.y-3,ht.direct);
					Thread t1 = new Thread(b);
					t1.start();
					buls.add(b);
					break;
				case 2:
					b=new Bullet(ht.x,ht.y,ht.direct);
					Thread t2 = new Thread(b);
					t2.start();
					buls.add(b);
					break;
				case 3:
					b=new Bullet(ht.x,ht.y-4,ht.direct);
					Thread t3 = new Thread(b);
					t3.start();
					buls.add(b);
					break;
				case 4:
					b=new Bullet(ht.x+5,ht.y-4,ht.direct);
					Thread t4 = new Thread(b);
					t4.start();
					buls.add(b);
					break;
				
				}
			}
			this.repaint();//丁云涛：每次都重画一次
		}
		
	}

	@Override
	//丁云涛：当该键放开时
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 画板界面的总逻辑方法
	 */
	public void logic(){
		//-----执行每个敌人坦克的逻辑判断-------
		for(EnemyTank et :ets){
			et.logic();
		}
		//-----执行每个敌人加强坦克的逻辑判断------
		for(PlusEnemyTank pet : pets){
			pet.logic();
		}
		//-----执行每个超级敌方坦克的逻辑判断------
		for(SuperEnemyTank set : sets){
			set.logic();
		}
		//-------敌方坦克子弹和英雄坦克的碰撞检测------------
		for(EnemyTank et : ets){
			for(Bullet b: et.etbs){
			if(b.x>ht.x+15||b.x+5<ht.x||b.y>ht.y+7||b.y+5<ht.y){
				//没碰撞
				
			}else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
			 	b.isLive=false;
				ht.isLive=false;
				}
			}
		}
		//-----加强版敌方坦克子弹和英雄坦克的碰撞检测------
		for(PlusEnemyTank pet : pets){
			for(Bullet b: pet.petbs){
			if(b.x>ht.x+15||b.x+5<ht.x||b.y>ht.y+7||b.y+5<ht.y){
				//没碰撞
				
			}else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
			 	b.isLive=false;
				ht.isLive=false;
				}
			}
		}
		//--------超级敌方坦克子弹和英雄坦克的碰撞检测--------
		for(SuperEnemyTank set : sets){
			for(Bullet b: set.setbs){
			if(b.x>ht.x+15||b.x+5<ht.x||b.y>ht.y+7||b.y+5<ht.y){
				//没碰撞
				
			}else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
			 	b.isLive=false;
				ht.isLive=false;
				}
			}
		}
		//-------进行英雄坦克子弹和每个敌人坦克的碰撞检测--------
		for(Bullet b :buls){
			for(EnemyTank et :ets){
				if(b.x>et.x+15||b.x+5<et.x||b.y>et.y+7||b.y+5<et.y){
					//没碰撞
				}else{
					Blast bl = new Blast(et.x, et.y);
					Thread t= new Thread(bl);
					t.start();
					bls.add(bl);
					b.isLive=false;
					et.isLive=false;
					score=score+10;
				}
			}
		}		
		//---------英雄坦克子弹和加强版敌方坦克的碰撞检测----------
		for(Bullet b :buls){
			for(PlusEnemyTank pet :pets){
				if(b.x>pet.x+15||b.x+5<pet.x||b.y>pet.y+7||b.y+5<pet.y){
					//没碰撞
				}else{
					b.isLive=false;
					pet.count++;
					if(pet.count==2){
						Blast bl = new Blast(pet.x, pet.y);
						Thread t= new Thread(bl);
						t.start();
						bls.add(bl);
						pet.isLive=false;
						score=score+20;
					}
				}
			}
		}		
		//-----------英雄坦克子弹和超级敌方坦克的碰撞检测----------
		for(Bullet b :buls){
			for(SuperEnemyTank set :sets){
				if(b.x>set.x+15||b.x+5<set.x||b.y>set.y+7||b.y+5<set.y){
					//没碰撞
				}else{
					b.isLive=false;
					set.count++;
					if(set.count==3){
						Blast bl = new Blast(set.x, set.y);
						Thread t= new Thread(bl);
						t.start();
						bls.add(bl);
						set.isLive=false;
						score=score+30;
					}
				}
			}
		}
		//-----------敌方坦克和英雄坦克之间的碰撞-----------
		for(EnemyTank et :ets){
			if(et.x>ht.x+15||et.x+5<ht.x||et.y>ht.y+7||et.y+5<ht.y){
				//没碰撞
			}
			else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
				ht.isLive=false;
				et.isLive=false;
			}
		}
		//-------------敌方加强坦克和英雄坦克之间的碰撞--------------
		for(PlusEnemyTank pet :pets){
			if(pet.x>ht.x+15||pet.x+5<ht.x||pet.y>ht.y+7||pet.y+5<ht.y){
				//没碰撞
			}
			else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
				ht.isLive=false;
			}
		}
		//------------敌方超级坦克和英雄坦克之间的碰撞-------------
		for(SuperEnemyTank set :sets){
			if(set.x>ht.x+15||set.x+5<ht.x||set.y>ht.y+7||set.y+5<ht.y){
				//没碰撞
			}
			else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
				ht.isLive=false;
			}
		}
		//--------------移除英雄子弹--------------
		for(Bullet b : buls){
			if(!b.isLive){
				buls.remove(b);
			}
		}
		//--------------移除敌方加强版坦克-----------
		for(PlusEnemyTank pet : pets){
			if(!pet.isLive){
				pets.remove(pet);
			}
		}
		//----------------移除敌方超级坦克---------------
		for(SuperEnemyTank set : sets){
			if(!set.isLive){
				sets.remove(set);
			}
		}
		//----------------移除爆炸效果--------------
		for(Blast bl:bls){
			if(!bl.isLive){
				bls.remove(bl);
			}
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
			logic();
			this.repaint();
			
		}
	}

}
