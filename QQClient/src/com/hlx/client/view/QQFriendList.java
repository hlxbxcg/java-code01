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
	//1.�����һ�ſ�Ƭ�����
	JPanel jp_main_1,jp_center_1,jp_buttom_1;
	JButton jp_main_1_jb1,jp_buttom_1_jb1,jp_buttom_1_jb2;
	JScrollPane jsp_1;
	//2.����ڶ��ſ�Ƭ�����
	JPanel jp_main_2,jp_center_2,jp_buttom_2;
	JButton jp_main_2_jb1,jp_buttom_2_jb1,jp_buttom_2_jb2;
	JScrollPane jsp_2;
	//3.��������ſ�Ƭ�����
	
	//4.����һ����Ƭ����
	CardLayout cl;
	
	
	public QQFriendList() {
		// TODO Auto-generated constructor stub
		//1.������Ƭһ��������
		jp_main_1=new JPanel(new BorderLayout());//�������ܵ�panel����
		jp_center_1=new JPanel(new GridLayout(50,1,4,4));//�����м��panel����
		//�����ĺ��壺1.2������ָ�����еĸ�����3.4���������������֮��ļ��
		jp_buttom_1=new JPanel(new GridLayout(2,1));
		
		//2.�����м�jpanel������
		JLabel []jls=new JLabel[50];
		for(int i=0;i<jls.length;i++){
			jls[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jls[i].addMouseListener(this);//Ϊÿ��jlabel�������ļ����¼�
			jp_center_1.add(jls[i]);
		}
		
		jsp_1=new JScrollPane(jp_center_1);
		
		//3.�����ײ�jpanel������
		jp_buttom_1_jb1=new JButton("İ����");
		jp_buttom_1_jb1.addActionListener(this);//��İ���������ť��ӵ���ļ����¼�
		jp_buttom_1_jb2=new JButton("������");		
		jp_buttom_1.add(jp_buttom_1_jb1);
		jp_buttom_1.add(jp_buttom_1_jb2);
		
		//4.����������jbutton
		jp_main_1_jb1=new JButton("�ҵĺ���");
		
		//5.�����ɵĸ����������ӵ��ܵĽ�����
		jp_main_1.add(jp_main_1_jb1,"North");
		jp_main_1.add(jsp_1,"Center");
		jp_main_1.add(jp_buttom_1,"South");
		
//-----------------------------------------------------
		//1.������Ƭ����������
		jp_main_2=new JPanel(new BorderLayout());//�������ܵ�panel����
		jp_center_2=new JPanel(new GridLayout(20,1,4,4));//�����м��panel����
		//�����ĺ��壺1.2������ָ�����еĸ�����3.4���������������֮��ļ��
		jp_buttom_2=new JPanel(new GridLayout(2,1));
				
		//2.�����м�jpanel������
		JLabel []jls2=new JLabel[20];
		for(int i=0;i<jls2.length;i++){
			jls2[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jp_center_2.add(jls2[i]);
			}
				
		jsp_2=new JScrollPane(jp_center_2);
				
		//3.��������jpanel������
		jp_main_2_jb1=new JButton("�ҵĺ���");
		jp_main_2_jb1.addActionListener(this);//���ڶ��������е��ҵĺ��Ѱ�ť��Ӽ����¼�
		jp_buttom_2_jb1=new JButton("İ����");		
		jp_buttom_2.add(jp_main_2_jb1);
		jp_buttom_2.add(jp_buttom_2_jb1);

				
		//4.�����ײ���jbutton
		jp_buttom_2_jb2=new JButton("������");
				
		//5.�����ɵĸ����������ӵ��ܵĽ�����
		jp_main_2.add(jp_buttom_2,"North");
		jp_main_2.add(jsp_2,"Center");
		jp_main_2.add(jp_buttom_2_jb2,"South");

		
		cl=new CardLayout();//������Ƭ���ֵ�ʵ��
		this.setLayout(cl);//����ǰ��������Ϊ��Ƭ����
		
		this.add(jp_main_1,"1");
		this.add(jp_main_2,"2");
		this.setSize(150, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * ��ĳ��ʱ�䱻ִ�е�ʱ�򴥷���
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==jp_buttom_1_jb1){//˵������˵�һ����Ƭ�У�İ���ˣ���ť
			cl.show(this.getContentPane(), "2");		
		}
		
		if(event.getSource()==jp_main_2_jb1){//˵������˵ڶ�����Ƭ�У��ҵĺ��ѣ���ť
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
