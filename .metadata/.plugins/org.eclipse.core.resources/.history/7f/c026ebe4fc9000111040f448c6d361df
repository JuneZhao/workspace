package com.qq.client.view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import com.qq.client.manage.*;
import com.qq.common.*;
public class QqChat extends JFrame implements ActionListener{

	JPanel jp1,jp2;
	JTextArea jta;
	JButton jb;
	JTextField jtf;
    String senderId;
    String receiverId;
    JScrollPane jsp;
    public QqChat(String senderId,String receiverId)
    {   
    	jp1=new JPanel(new BorderLayout());
    	jp2=new JPanel();
    	jta=new JTextArea();
    	jsp=new JScrollPane(jta);
    	jtf=new JTextField(20);
    	jb=new JButton("发送");
    	jb.addActionListener(this);
    	
    	jp1.add(jsp,"Center");
    	jp2.add(jtf);
    	jp2.add(jb);
    	
    	this.senderId = senderId;
    	this.receiverId = receiverId;
    	
    	this.add(jp1);
    	this.setTitle(senderId+"正在和"+receiverId+"聊天");
    	this.add(jp2,"South");
    	this.setSize(380,200);
    	this.setVisible(true);
    }
    
    public void show(Message m)
    {
    	this.jta.append(m.getSenderId()+"对"+m.getReceiverId()+"说:"+m.getContent());
    	this.jta.append("\n");
    }
    
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == jb)
		{
			Message m=new Message();
			m.setMsgType(MessageType.Message_Normal);
			m.setSenderId(senderId);
			m.setReceiverId(receiverId);
			m.setContent(jtf.getText());
			
			show(m);
			jtf.setText("");
			ClientConnectServerThread ccst=ManageCCST.get(senderId);
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ccst.getS().getOutputStream());
				oos.writeObject(m);
				
			    System.out.println(m.getSenderId()+"给"+m.getReceiverId()+"的信息"+m.getContent());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
		}
	}
}
