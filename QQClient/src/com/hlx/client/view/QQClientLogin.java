package com.hlx.client.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class QQClientLogin extends JFrame implements ActionListener {
	//1.������ߵ����
	JLabel jlb;
	//2.�������ϱߵ����
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	//3.�����м䲿�ֵ����
	JTabbedPane jtp;//��Ƭ������
	JPanel jp_qq,jp_phone,jp_email;
	
	JLabel qq_jl1,qq_jl2,qq_jl3,qq_jl4;
	JButton qq_jb;
	JTextField qq_jtf;
	JPasswordField qq_jpf;
	JCheckBox qq_jcb1,qq_jcb2;
	
	@SuppressWarnings("unused")
	public QQClientLogin() {
		// TODO Auto-generated constructor stub
		int a;
		//1.�������������ʵ��
		jlb=new JLabel(new ImageIcon("images/tou.gif"));
		
		//2.�����ϱ������ʵ��
		jp1=new JPanel(new FlowLayout());
		jp1_jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jp1_jb1.addActionListener(this);//����½��ť��Ӽ����¼�
		
		
		jp1_jb2=new JButton(new ImageIcon("images/quxiao.gif"));
		jp1_jb3=new JButton(new ImageIcon("images/xiangdao.gif"));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		//3.�����м������ʵ��
		jp_qq=new JPanel(new GridLayout(3,3));
		jp_phone=new JPanel();
		jp_email=new JPanel();
		
		qq_jl1=new JLabel("QQ�˺�",JLabel.CENTER);
		qq_jl2=new JLabel("QQ����",JLabel.CENTER);
		qq_jl3=new JLabel("��������",JLabel.CENTER);
		qq_jl3.setForeground(Color.BLUE);
		qq_jl4=new JLabel("�������뱣��",JLabel.CENTER);
		
		
		qq_jb=new JButton(new ImageIcon("image/clear.gif"));
		qq_jtf=new JTextField();
		qq_jpf=new JPasswordField();
		
		qq_jcb1=new JCheckBox("�����¼");
		qq_jcb2=new JCheckBox("��ס����");
		
		jp_qq.add(qq_jl1);
		jp_qq.add(qq_jtf);
		jp_qq.add(qq_jb);
		jp_qq.add(qq_jl2);
		jp_qq.add(qq_jpf);
		jp_qq.add(qq_jl3);
		jp_qq.add(qq_jcb1);
		jp_qq.add(qq_jcb2);
		jp_qq.add(qq_jl4);
		
		jtp=new JTabbedPane();//ʵ�廯��Ƭ������
		//������������ӵ���Ƭ��������
		jtp.add("QQ����",jp_qq);
		jtp.add("�绰����",jp_phone);
		jtp.add("�����ʼ�",jp_email);
		
		
		
		
		//4.�������������ӵ�������
		this.add(jlb,"North");
		this.add(jtp,"Center");
		this.add(jp1,"South");
		this.setSize(350,240);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==jp1_jb1){
			
			String name=qq_jtf.getText().trim();
			String pass=new String(qq_jpf.getPassword());
//			User user=new User();
//			user.setName(name);
//			user.setPass(pass);
//			if(QQClient.sendUserToServer(user)){
//				
//			
			//�Ϸ��û�
			new QQFriendList();
			this.dispose();//��һ������ر�
//		}else{
//			JOptionPane.showMessageDialog(this,"�û������������");
		}
	}
}
