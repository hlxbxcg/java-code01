package com.hlx07.one;
import javax.swing.JFrame;
/**
 * 
 * 
 * @author 
 *MyScreen������ã�����̳���JFrame�࣬������Windows����ʾ�Ľ���
 */
@SuppressWarnings("serial")
public class MyScreen extends JFrame {
	public MyScreen() {
/*
 * MyScreen�Ĺ���
 */	
		// TODO Auto-generated constructor stub
		//���ý���ĳߴ�
		this.setSize(500,400);
		//���ý����ʼ����λ��
		this.setLocation(300, 200);
		//���ý����С����
		this.setResizable(false);
		//���ý������
		this.setTitle("���ݳ���ѧԺ");
		//��������ӵ�������
		MyPanel panel=new MyPanel();
		
		Thread t=new Thread(panel);
		t.start();
		this.add(panel);
		this.setVisible(true);
		
		
	
		
	}
}

