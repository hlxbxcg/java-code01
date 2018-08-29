package com.dyt02.base;

import javax.swing.JFrame;
/**
 * 丁云涛：继承JFrame这个类来设定画面
 * @author dyt
 *
 */
@SuppressWarnings("serial")
class MyScreen extends JFrame{
	/*
	 * 丁云涛：定义一个MyScreen的构造方法来设定画面大小以及初始所在位置
	 */
	public MyScreen() {
		// TODO Auto-generated constructor stub
		this.setSize(500,400);//丁云涛：设置大小
		this.setVisible(true);//丁云涛：设置可见
		this.setTitle("兰州城市学院");//丁云涛：设置标题
		this.setLocation(300,200);//丁云涛：设置初始位置
		MyPanel panel=new MyPanel();
		this.add(panel);	//丁云涛：将panel加入
		this.addKeyListener(panel);	//丁云涛：将KeyListener加入
		Thread t = new Thread(panel);
		t.start();
		this.setResizable(false);//丁云涛：设置大小不可变
	}

}
