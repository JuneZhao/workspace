package com.qq.client.manage;

import java.util.*;
import java.io.*;
import java.net.*;

import com.qq.common.*;
import com.qq.client.view.*;
public class ClientConnectServerThread extends Thread{
      Socket s;
    public Socket getS() {
		return s;
	}
	public ClientConnectServerThread(Socket s)
      {
    	  this.s = s;
      }
      public void run()
      {
    	  while(ManageCCST.getCountCCST()>=0)
    	  {
    		  try {
    			
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
				if(m.getMsgType() == MessageType.Message_Normal)
				{
					System.out.println("�յ�����Ϣ"+m.getSenderId()+" "+ m.getReceiverId()+" "+m.getContent());
					QqChat qc=ManageQqChat.get(m.getReceiverId()+" "+ m.getSenderId());
					if(qc!=null)
					   qc.show(m);
					else
					{
						QqChat qcTemp=new QqChat(m.getReceiverId(),m.getSenderId());
						ManageQqChat.add(m.getReceiverId()+" "+ m.getSenderId(), qcTemp);
						qcTemp.show(m);
					}
				}
				if(m.getMsgType() == MessageType.Message_ret_FriendOnline)
				{   
					//sleep(500);
					System.out.println(m.getReceiverId()+"�ͻ������ߺ���"+m.getContent());
					QqList qqList=ManageQqList.getQqList(m.getReceiverId());
					qqList.updateFriend(m.getContent());	
				}
				if(m.getMsgType() == MessageType.Message_Notify)
				{   
					//sleep(100);
					System.out.println(m.getSenderId()+"������");
					QqList qqList=ManageQqList.getQqList(m.getReceiverId());
					qqList.updateFriend(m.getSenderId());				
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
    	  }
      }
}