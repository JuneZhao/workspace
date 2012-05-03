package com.qq.server.view;
import java.awt.*;
import javax.swing.*;

import com.qq.server.modul.*;

import java.awt.event.*;
public class QqServer extends JFrame implements ActionListener{
    
	JPanel jp=null;
	JButton jb1=null,jb2=null;
	ServerConnetClient scc;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqServer qs=new QqServer();
	}
    
	public QqServer()
	{
		jp=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jb2.addActionListener(this);
		
		jp.add(jb1,"Right");
		jp.add(jb2,"Right");
		
		this.add(jp,"North");
		
		this.setSize(300,400);
		this.setTitle("QQ服务器");
		this.setLocation(200,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb1)
		{
			scc=new ServerConnetClient();
		}
		if(e.getSource() == jb2)
		{
			if(scc != null)
			{
				int selection=JOptionPane.showConfirmDialog(this, "还有连接未关闭，你确定关闭服务器? ",   "弹出确认", 
					JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE); 
				if(selection==JOptionPane.OK_OPTION)
				{
						this.dispose();	
				}
			}
			else
			{
				this.dispose();
			}
		}
	}
}
