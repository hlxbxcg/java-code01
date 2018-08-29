package com.hlx.client.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QQChat extends JFrame {
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	public QQChat(String friend){
		
		//2.创建出组件的实体
		jta=new JTextArea();
		jtf=new JTextField (15);
		jb=new JButton("发送");
		jp=new JPanel();
		
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setTitle("你正在和"+friend+"聊天");
		
		
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

}
