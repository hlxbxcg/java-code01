package com.hlx.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class QQFriendList extends JFrame implements ActionListener, MouseListener {
	//1.定义第一张卡片的组件
	JPanel jp_main_1,jp_center_1,jp_buttom_1;
	JButton jp_main_1_jb1,jp_buttom_1_jb1,jp_buttom_1_jb2;
	JScrollPane jsp_1;
	//2.定义第二张卡片的组件
	JPanel jp_main_2,jp_center_2,jp_buttom_2;
	JButton jp_main_2_jb1,jp_buttom_2_jb1,jp_buttom_2_jb2;
	JScrollPane jsp_2;
	//3.定义第三张卡片的组件
	
	//4.定义一个卡片布局
	CardLayout cl;
	
	
	public QQFriendList() {
		// TODO Auto-generated constructor stub
		//1.创建卡片一里面的组件
		jp_main_1=new JPanel(new BorderLayout());//创建出总的panel界面
		jp_center_1=new JPanel(new GridLayout(50,1,4,4));//创建中间的panel界面
		//参数的含义：1.2个参数指定行列的个数；3.4个参数，表征表格之间的间距
		jp_buttom_1=new JPanel(new GridLayout(2,1));
		
		//2.创建中间jpanel的内容
		JLabel []jls=new JLabel[50];
		for(int i=0;i<jls.length;i++){
			jls[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jls[i].addMouseListener(this);//为每个jlabel设置鼠标的监听事件
			jp_center_1.add(jls[i]);
		}
		
		jsp_1=new JScrollPane(jp_center_1);
		
		//3.创建底部jpanel的内容
		jp_buttom_1_jb1=new JButton("陌生人");
		jp_buttom_1_jb1.addActionListener(this);//给陌生人这个按钮添加点击的监听事件
		jp_buttom_1_jb2=new JButton("黑名单");		
		jp_buttom_1.add(jp_buttom_1_jb1);
		jp_buttom_1.add(jp_buttom_1_jb2);
		
		//4.创建顶部的jbutton
		jp_main_1_jb1=new JButton("我的好友");
		
		//5.将生成的各部分组件添加到总的界面中
		jp_main_1.add(jp_main_1_jb1,"North");
		jp_main_1.add(jsp_1,"Center");
		jp_main_1.add(jp_buttom_1,"South");
		
//-----------------------------------------------------
		//1.创建卡片二里面的组件
		jp_main_2=new JPanel(new BorderLayout());//创建出总的panel界面
		jp_center_2=new JPanel(new GridLayout(20,1,4,4));//创建中间的panel界面
		//参数的含义：1.2个参数指定行列的个数；3.4个参数，表征表格之间的间距
		jp_buttom_2=new JPanel(new GridLayout(2,1));
				
		//2.创建中间jpanel的内容
		JLabel []jls2=new JLabel[20];
		for(int i=0;i<jls2.length;i++){
			jls2[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jp_center_2.add(jls2[i]);
			}
				
		jsp_2=new JScrollPane(jp_center_2);
				
		//3.创建顶部jpanel的内容
		jp_main_2_jb1=new JButton("我的好友");
		jp_main_2_jb1.addActionListener(this);//给第二个界面中的我的好友按钮添加监听事件
		jp_buttom_2_jb1=new JButton("陌生人");		
		jp_buttom_2.add(jp_main_2_jb1);
		jp_buttom_2.add(jp_buttom_2_jb1);

				
		//4.创建底部的jbutton
		jp_buttom_2_jb2=new JButton("黑名单");
				
		//5.将生成的各部分组件添加到总的界面中
		jp_main_2.add(jp_buttom_2,"North");
		jp_main_2.add(jsp_2,"Center");
		jp_main_2.add(jp_buttom_2_jb2,"South");

		
		cl=new CardLayout();//创建卡片布局的实例
		this.setLayout(cl);//将当前界面设置为卡片布局
		
		this.add(jp_main_1,"1");
		this.add(jp_main_2,"2");
		this.setSize(150, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * 当某个时间被执行的时候触发的
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==jp_buttom_1_jb1){//说明点击了第一个卡片中（陌生人）按钮
			cl.show(this.getContentPane(), "2");		
		}
		
		if(event.getSource()==jp_main_2_jb1){//说明点击了第二个卡片中（我的好友）按钮
			cl.show(this.getContentPane(), "1");		
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		JLabel jb=(JLabel) event.getSource();
		if(event.getClickCount()==2){
			new QQChat(jb.getText());
		}
		
	}
	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel) event.getSource();
		jl.setForeground(Color.RED);
		
	}
	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel) event.getSource();
		jl.setForeground(Color.BLACK);
		
	}

}
