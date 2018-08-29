package com.hlx07.one;
import javax.swing.JFrame;
/**
 * 
 * 
 * @author 
 *MyScreen类的作用；该类继承了JFrame类，可以做Windows中显示的界面
 */
@SuppressWarnings("serial")
public class MyScreen extends JFrame {
	public MyScreen() {
/*
 * MyScreen的构造
 */	
		// TODO Auto-generated constructor stub
		//设置界面的尺寸
		this.setSize(500,400);
		//设置界面初始化的位置
		this.setLocation(300, 200);
		//设置界面大小不变
		this.setResizable(false);
		//设置界面标题
		this.setTitle("兰州城市学院");
		//将画板添加到界面上
		MyPanel panel=new MyPanel();
		
		Thread t=new Thread(panel);
		t.start();
		this.add(panel);
		this.setVisible(true);
		
		
	
		
	}
}

