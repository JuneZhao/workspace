package com.qq.client.view;
import java.awt.*;
import javax.swing.*;

import com.qq.client.manage.*;
//import com.qq.common.*;

import java.awt.event.*;
public class QqList extends JFrame implements ActionListener,MouseListener{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp1,jp2,jp3,jpFriend,jpStranger,jpBlack,jpMiddle1,jpMiddle2,jpMiddle3;
	JButton jp1_jb1,jp1_jb2,jp1_jb3,jp2_jb1,jp2_jb2,jp2_jb3;
	JScrollPane jsp1,jsp2,jsp3;
	CardLayout cl;
	JLabel []jp1_jl;
	String ownerId;
	//利用卡片布局
	public QqList(String ownerId)
	{
		this.ownerId=ownerId;
	    FirstPanel();
	    SecondPanel();
	    
	    cl=new CardLayout();
	    this.setLayout(cl);
	    this.add(jpFriend,"1");
	    this.add(jpStranger,"2");
	    this.setTitle(ownerId);
	    this.setSize(160,400);
	    this.setVisible(true);
	    this.setLocation(100,200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void updateFriend(String onlineFriendId)
	{   
		String Friend[]=onlineFriendId.split(" ");
        for(int i=0;i<Friend.length;++i)
        {   
        	if(onlineFriendId.equals(ownerId))
        	   continue;
        	System.out.println(ownerId+"的现在好友有"+Friend[i]+" ");
//        	jp1_jl[Integer.parseInt(Friend[i])-1].set
        	jp1_jl[Integer.parseInt(Friend[i])-1].setEnabled(true);
        }
	}
/*	public void processWindowEvent(WindowEvent e)
	{   
		boolean b=false;
		if(e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			int nSelection=JOptionPane.showConfirmDialog(this,"你确定退出?","弹出确认",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			if(nSelection == JOptionPane.OK_OPTION)
			{
				System.out.println("弹出确认");
				Message m=new Message();
				m.setMsgType(MessageType.Message_Logout);
				m.setSenderId(ownerId);
				ClientConnectServerThread ccst=ManageCCST.get(ownerId);
				try {
					ObjectOutputStream oos=new ObjectOutputStream(ccst.getS().getOutputStream());
					oos.writeObject(m);
					
					ManageCCST.get(ownerId).getS().close();
					ManageCCST.remove(ownerId);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}finally{
					
				}
				
			   this.dispose();
			  	
			}

		}
	} */
	public void FirstPanel()
	{
		jp1_jb1=new JButton("我的好友");
		jp1_jb1.addActionListener(this);
	    
		jp1_jb2=new JButton("陌生人");
		jp1_jb2.addActionListener(this);
		jp1_jb3=new JButton("黑名单");

	    jp1_jl=new JLabel[50];
	    jpMiddle1=new JPanel(new GridLayout(50,1));
		for(int i=0;i<jp1_jl.length;++i)
		{   
			jp1_jl[i]=new JLabel(i+1+" ",new ImageIcon("Image/1.jpg"),JLabel.LEFT);
			jp1_jl[i].addMouseListener(this);
			jpMiddle1.add(jp1_jl[i]);
			if(jp1_jl[i].getText().trim().equals(ownerId))
			{
				jp1_jl[i].setEnabled(true);
			}
			else
			{
				jp1_jl[i].setEnabled(false);
			}
		}
		jsp1=new JScrollPane(jpMiddle1);
		
	    jp1=new JPanel(new GridLayout(2,1,1,1));
	    
	    jpFriend=new JPanel(new BorderLayout());
	    jp1.add(jp1_jb2);
	    jp1.add(jp1_jb3);
	    
	    jpFriend.add(jp1_jb1,"North");
	    jpFriend.add(jsp1);
	    jpFriend.add(jp1,"South");
	}
	public void SecondPanel()
	{   
		jp2_jb1=new JButton("我的好友");
		jp2_jb1.addActionListener(this);
	    
		jp2_jb2=new JButton("陌生人");
		jp2_jb2.addActionListener(this);
		jp2_jb3=new JButton("黑名单");
	    
	    JLabel []jp2_jl=new JLabel[20];
	    jpMiddle2=new JPanel(new GridLayout(20,1));
		for(int i=0;i<jp2_jl.length;++i)
		{   
			jp2_jl[i]=new JLabel(i+1+" ",new ImageIcon(),JLabel.LEFT);
			jp2_jl[i].addMouseListener(this);
			jpMiddle2.add(jp2_jl[i]);
		}
		jsp2=new JScrollPane(jpMiddle2);
		
	    jp2=new JPanel(new GridLayout(2,1,1,1));
	    jpStranger=new JPanel(new BorderLayout());
	    jp2.add(jp2_jb1);
	    jp2.add(jp2_jb3);
	    
	    jpStranger.add(jp2_jb2,"North");
	    jpStranger.add(jsp2);
	    jpStranger.add(jp2,"South");
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jp1_jb2)
		{  
			cl.show(this.getContentPane(), "2");
		}
		if(e.getSource() == jp2_jb1)
		{
			cl.show(this.getContentPane(), "1");
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount() == 2)
		{   
			JLabel jl=(JLabel)arg0.getSource();
			if(!jl.getText().trim().equals(this.getTitle()) && !ManageQqChat.isQqChatExist(this.getTitle()+" "+jl.getText().trim()))			
			{
			QqChat qc=new QqChat(this.getTitle(),jl.getText().trim());
			System.out.println(this.getTitle()+" "+jl.getText().trim());
			ManageQqChat.add(this.getTitle()+" "+jl.getText().trim(), qc);
			}
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		  jl.setForeground(Color.blue);
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		  jl.setForeground(Color.black);
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
