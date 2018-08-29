package com.hlx07.one;

import java.awt.Graphics;


import java.awt.Font;
import java.awt.Color;
import java.awt.Image;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author
 * @create
 */

public class MyPanel extends JPanel implements Runnable  {
	int x=300,y=100;
	Image []images=new Image[10];
	int n=0;
	public MyPanel(){
		// TODO Auto-generated method stub
	
		try{
		    for(int i=0;i<10;i++){
			   File input=new File("src/image/fish"+i+".png");
			   images[i]=ImageIO.read(input);
		    }
		}catch(IOException e){
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}	
	//重写
	@Override
	public void paint(Graphics g) {
		//TODO Auto-generated method stub
		 super.paint(g); 
		g.drawImage(images[n], x, y, this);
     }	
 	//重写
	public void run() {
		// TODO Auto-generated method stub
		//线程，每60毫秒执行一次
		while(true){
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			x--;
			this.repaint();
			if(n>9){
				n=0;
			}
		}
	}

}
