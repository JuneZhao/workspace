package com.qq.server.thread;

import java.util.*;
import java.net.*;
import java.io.*;

import com.qq.common.*;

public class ServerConnectClientThread extends Thread{
    Socket s;  
	public ServerConnectClientThread(Socket s)
	{
		this.s=s;
	}
	public Socket getS()
	{
		return s;
	}
	public void notifyAll(String onlineId)
	{
		Message  m=new Message();
		m.setSenderId(onlineId);
		m.setMsgType(MessageType.Message_Notify); 
		String szFriend[]=ManageSCCT.getOnlineFriend().split(" ");
		for(int i=0;i<ManageSCCT.getCountSCCT();++i)
		{	
			System.out.println(szFriend[i]);
			if(onlineId.equals(szFriend[i]))
				continue;
			ObjectOutputStream oos;
			try {
				m.setReceiverId(szFriend[i]);
				oos = new ObjectOutputStream(ManageSCCT.get(szFriend[i]).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void run()
	{
		while(ManageSCCT.getCountSCCT()>0)
		{
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
				if(m.getMsgType() == MessageType.Message_Normal)
				{   
					System.out.println("�յ���Ϣ"+m.getSenderId()+" "+m.getReceiverId());
					ObjectOutputStream oos=new ObjectOutputStream(ManageSCCT.get(m.getReceiverId()).getS().getOutputStream());
					oos.writeObject(m);
				}
				else if(m.getMsgType() == MessageType.Message_Logout)
				{
					s.close();
					ManageSCCT.remove(m.getSenderId());	
				}
				else if(m.getMsgType() == MessageType.Message_FriendOnline)
				{
					m.setMsgType(MessageType.Message_ret_FriendOnline);
					m.setReceiverId(m.getSenderId());
					m.setContent(ManageSCCT.getOnlineFriend());
					System.out.println(m.getSenderId()+"�����ߺ�����:"+ManageSCCT.getOnlineFriend());
					ObjectOutputStream oosFriendOnline=new ObjectOutputStream(ManageSCCT.get(m.getSenderId()).getS().getOutputStream());
					oosFriendOnline.writeObject(m);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				
			}
 		}
	}
}