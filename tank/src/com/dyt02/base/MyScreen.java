package com.dyt02.base;

import javax.swing.JFrame;
/**
 * �����Σ��̳�JFrame��������趨����
 * @author dyt
 *
 */
@SuppressWarnings("serial")
class MyScreen extends JFrame{
	/*
	 * �����Σ�����һ��MyScreen�Ĺ��췽�����趨�����С�Լ���ʼ����λ��
	 */
	public MyScreen() {
		// TODO Auto-generated constructor stub
		this.setSize(500,400);//�����Σ����ô�С
		this.setVisible(true);//�����Σ����ÿɼ�
		this.setTitle("���ݳ���ѧԺ");//�����Σ����ñ���
		this.setLocation(300,200);//�����Σ����ó�ʼλ��
		MyPanel panel=new MyPanel();
		this.add(panel);	//�����Σ���panel����
		this.addKeyListener(panel);	//�����Σ���KeyListener����
		Thread t = new Thread(panel);
		t.start();
		this.setResizable(false);//�����Σ����ô�С���ɱ�
	}

}
