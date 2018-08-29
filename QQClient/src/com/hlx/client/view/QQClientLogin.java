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
	//1.定义最北边的组件
	JLabel jlb;
	//2.定义最南边的组件
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	//3.定义中间部分的组件
	JTabbedPane jtp;//卡片管理器
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
		//1.创建北边组件的实体
		jlb=new JLabel(new ImageIcon("images/tou.gif"));
		
		//2.创建南边组件的实体
		jp1=new JPanel(new FlowLayout());
		jp1_jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jp1_jb1.addActionListener(this);//给登陆按钮添加监听事件
		
		
		jp1_jb2=new JButton(new ImageIcon("images/quxiao.gif"));
		jp1_jb3=new JButton(new ImageIcon("images/xiangdao.gif"));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		//3.创建中间组件的实体
		jp_qq=new JPanel(new GridLayout(3,3));
		jp_phone=new JPanel();
		jp_email=new JPanel();
		
		qq_jl1=new JLabel("QQ账号",JLabel.CENTER);
		qq_jl2=new JLabel("QQ密码",JLabel.CENTER);
		qq_jl3=new JLabel("忘记密码",JLabel.CENTER);
		qq_jl3.setForeground(Color.BLUE);
		qq_jl4=new JLabel("申请密码保护",JLabel.CENTER);
		
		
		qq_jb=new JButton(new ImageIcon("image/clear.gif"));
		qq_jtf=new JTextField();
		qq_jpf=new JPasswordField();
		
		qq_jcb1=new JCheckBox("隐身登录");
		qq_jcb2=new JCheckBox("记住密码");
		
		jp_qq.add(qq_jl1);
		jp_qq.add(qq_jtf);
		jp_qq.add(qq_jb);
		jp_qq.add(qq_jl2);
		jp_qq.add(qq_jpf);
		jp_qq.add(qq_jl3);
		jp_qq.add(qq_jcb1);
		jp_qq.add(qq_jcb2);
		jp_qq.add(qq_jl4);
		
		jtp=new JTabbedPane();//实体化卡片管理器
		//将三个画板添加到卡片管理器中
		jtp.add("QQ号码",jp_qq);
		jtp.add("电话号码",jp_phone);
		jtp.add("电子邮件",jp_email);
		
		
		
		
		//4.将创建的组件添加到界面中
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
			//合法用户
			new QQFriendList();
			this.dispose();//第一个界面关闭
//		}else{
//			JOptionPane.showMessageDialog(this,"用户名或密码错误");
		}
	}
}
