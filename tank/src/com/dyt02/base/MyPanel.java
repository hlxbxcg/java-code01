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
 * �����Σ�implements���ڼ̳���һ��������ࣨKeyListener����������ϵ��һ��
 * @author dyt
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel implements KeyListener,Runnable {

	int a=0;
	int n=4;
	int c=0;
	int q=1;
	//-----------����һ���Ʒְ�-------------
	Integer score=0;
	//--------����һ��Ӣ��̹�˵ļ���-----------
	HeroTank ht;
	//--------����һ���������ڴ�ŵ��˵�̹��----------
	CopyOnWriteArrayList<EnemyTank> ets = new CopyOnWriteArrayList<EnemyTank>();
	//-------����һ���������ڴ�ż�ǿ����˵�̹��---------
	CopyOnWriteArrayList<PlusEnemyTank> pets = new CopyOnWriteArrayList<PlusEnemyTank>();
	//-------����һ���������ڴ�ų�������˵�̹��----------
	CopyOnWriteArrayList<SuperEnemyTank> sets = new CopyOnWriteArrayList<SuperEnemyTank>();
	//---------����һ���������ڴ��Ӣ�۵��ӵ�------------
	CopyOnWriteArrayList<Bullet> buls = new CopyOnWriteArrayList<Bullet>();
	//--------����һ����ը�ļ���-----------------
	CopyOnWriteArrayList<Blast> bls = new CopyOnWriteArrayList<Blast>();
	Bullet b;
	public MyPanel(){
		//-------------����Ӣ�۵�̹��--------------
		ht = new HeroTank(200, 280, 1);
		//-------------�������˵�̹��--------------
		for(int i=0;i<n;i++){
			EnemyTank  et=new EnemyTank(50+i*100, 100,2);
			Thread t = new Thread(et);
			t.start();
			ets.add(et);
			}
}
	
	public void paint(Graphics g) {
		super.paint(g);
		//---------�������Ϊ��ɫ----------
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 400);
		//----------���ƼƷְ�-----------
		String scores = Integer.toString(score);
		g.setColor(Color.GREEN);
		g.setFont(new Font(scores,Font.BOLD, 25));
		g.drawString(scores,400,50);
		//---------�������б�ըЧ��----------
		for(Blast bl:bls){
			bl.drawSelf(g);
		}
		//---------����Ӣ��̹��-----------
		if(ht.isLive){
		ht.drawSelf(g);
		}
		//---------Ӣ��̹������----------
		if(!ht.isLive){
			ht.x=-1000;
			ht.y=-1000;
		}
		//---------���Ƶ���̹��----------
		if(score<40){
		for(EnemyTank et:ets){
			if(et.isLive)
			et.drawSelf(g);
			}
		}
		//-------------������ǿ����˵�̹��---------------
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
		//--------���Ƶз���ǿ��̹��---------
		for(PlusEnemyTank pet : pets){
				if(pet.isLive){
					pet.drawSelf(g);
				}
			}
		}
		//-------------�����з�����̹��-----------------
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
		//---------���Ƶз�����̹��-----------
		for(SuperEnemyTank set : sets){
			if(set.isLive){
				set.drawSelf(g);
			}
		}
	}
		//--------����Ӣ��̹���ӵ�---------
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
		//-----------���Ƶз�̹���ӵ�------------
		for(EnemyTank et : ets){
			for(Bullet b : et.etbs)
				if(b.isLive){
				b.drawSelf(g);
				}
		}
			//---------���Ƽ�ǿ��з�̹���ӵ�--------
			if(score>=40&&score<120){
				for(PlusEnemyTank pet : pets){
					for(Bullet b : pet.petbs)
						if(b.isLive){
							b.drawSelf(g);
						}
				}
			}
			//---------���Ƴ�������̹���ӵ�----------
			if(score>=120){
				for(SuperEnemyTank set : sets){
					for(Bullet b : set.setbs)
						if(b.isLive){
							b.drawSelf(g);
						}
				}
			}
			//-------------�Ƴ��з�̹��--------------
			for(EnemyTank et : ets){
				if(!et.isLive){
					Blast blast=new Blast(et.x+15, et.y+15);
					blast.drawSelf(g);
					ets.remove(et);
				}
			}
		}
	@Override
	//�����Σ�KeyPressed���ã����ü�����ʱ���еĲ���
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(ht.isLive){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP://�����Σ�����
				ht.direct=1;
				if(ht.y>=5){
					ht.y-=ht.speed;
				}
				break;
			case KeyEvent.VK_DOWN://�����Σ�����
				ht.direct=2;
				if(ht.y<=340){
				ht.y+=ht.speed;
				}
				break;
			case KeyEvent.VK_LEFT://�����Σ�����
				ht.direct=3;
				if(ht.x>=5){
				ht.x-=ht.speed;
				}
				break;
			case KeyEvent.VK_RIGHT://�����Σ�����
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
			this.repaint();//�����Σ�ÿ�ζ��ػ�һ��
		}
		
	}

	@Override
	//�����Σ����ü��ſ�ʱ
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * �����������߼�����
	 */
	public void logic(){
		//-----ִ��ÿ������̹�˵��߼��ж�-------
		for(EnemyTank et :ets){
			et.logic();
		}
		//-----ִ��ÿ�����˼�ǿ̹�˵��߼��ж�------
		for(PlusEnemyTank pet : pets){
			pet.logic();
		}
		//-----ִ��ÿ�������з�̹�˵��߼��ж�------
		for(SuperEnemyTank set : sets){
			set.logic();
		}
		//-------�з�̹���ӵ���Ӣ��̹�˵���ײ���------------
		for(EnemyTank et : ets){
			for(Bullet b: et.etbs){
			if(b.x>ht.x+15||b.x+5<ht.x||b.y>ht.y+7||b.y+5<ht.y){
				//û��ײ
				
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
		//-----��ǿ��з�̹���ӵ���Ӣ��̹�˵���ײ���------
		for(PlusEnemyTank pet : pets){
			for(Bullet b: pet.petbs){
			if(b.x>ht.x+15||b.x+5<ht.x||b.y>ht.y+7||b.y+5<ht.y){
				//û��ײ
				
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
		//--------�����з�̹���ӵ���Ӣ��̹�˵���ײ���--------
		for(SuperEnemyTank set : sets){
			for(Bullet b: set.setbs){
			if(b.x>ht.x+15||b.x+5<ht.x||b.y>ht.y+7||b.y+5<ht.y){
				//û��ײ
				
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
		//-------����Ӣ��̹���ӵ���ÿ������̹�˵���ײ���--------
		for(Bullet b :buls){
			for(EnemyTank et :ets){
				if(b.x>et.x+15||b.x+5<et.x||b.y>et.y+7||b.y+5<et.y){
					//û��ײ
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
		//---------Ӣ��̹���ӵ��ͼ�ǿ��з�̹�˵���ײ���----------
		for(Bullet b :buls){
			for(PlusEnemyTank pet :pets){
				if(b.x>pet.x+15||b.x+5<pet.x||b.y>pet.y+7||b.y+5<pet.y){
					//û��ײ
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
		//-----------Ӣ��̹���ӵ��ͳ����з�̹�˵���ײ���----------
		for(Bullet b :buls){
			for(SuperEnemyTank set :sets){
				if(b.x>set.x+15||b.x+5<set.x||b.y>set.y+7||b.y+5<set.y){
					//û��ײ
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
		//-----------�з�̹�˺�Ӣ��̹��֮�����ײ-----------
		for(EnemyTank et :ets){
			if(et.x>ht.x+15||et.x+5<ht.x||et.y>ht.y+7||et.y+5<ht.y){
				//û��ײ
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
		//-------------�з���ǿ̹�˺�Ӣ��̹��֮�����ײ--------------
		for(PlusEnemyTank pet :pets){
			if(pet.x>ht.x+15||pet.x+5<ht.x||pet.y>ht.y+7||pet.y+5<ht.y){
				//û��ײ
			}
			else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
				ht.isLive=false;
			}
		}
		//------------�з�����̹�˺�Ӣ��̹��֮�����ײ-------------
		for(SuperEnemyTank set :sets){
			if(set.x>ht.x+15||set.x+5<ht.x||set.y>ht.y+7||set.y+5<ht.y){
				//û��ײ
			}
			else{
				Blast bl = new Blast(ht.x, ht.y);
				Thread t= new Thread(bl);
				t.start();
				bls.add(bl);
				ht.isLive=false;
			}
		}
		//--------------�Ƴ�Ӣ���ӵ�--------------
		for(Bullet b : buls){
			if(!b.isLive){
				buls.remove(b);
			}
		}
		//--------------�Ƴ��з���ǿ��̹��-----------
		for(PlusEnemyTank pet : pets){
			if(!pet.isLive){
				pets.remove(pet);
			}
		}
		//----------------�Ƴ��з�����̹��---------------
		for(SuperEnemyTank set : sets){
			if(!set.isLive){
				sets.remove(set);
			}
		}
		//----------------�Ƴ���ըЧ��--------------
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
