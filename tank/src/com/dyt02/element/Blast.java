package com.dyt02.element;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Blast implements Runnable{
	public int x, y;
	int count=0;
	public boolean isLive = true;
	Image[] images = new Image[8];

	public Blast(int x, int y) {
		try {
			for (int i = 0; i < 8; i++) {
				File input = new File("src/image/blast" + (i + 1) + ".gif");
				images[i] = ImageIO.read(input);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.x = x;
		this.y = y;
	}

	public void drawSelf(Graphics g) {
			if (isLive) {
				g.drawImage(images[count], x, y, 38, 30, null);
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
			count++;
			if(count>7){
				isLive=false;
			}
			
		}
	}
}
