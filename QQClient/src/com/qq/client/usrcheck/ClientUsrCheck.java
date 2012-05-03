package com.qq.client.usrcheck;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import com.qq.client.manage.*;
import com.qq.common.*;

public class ClientUsrCheck {
	
	Socket s;
	public int SendLoginInfoToServer(String usrId,String password)
    {
	  int nFlag=MessageType.Message_LoginFail;
      try {
	   s=new Socket("127.0.0.1",999);
	   ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
	   oos.writeObject(usrId+" "+password);
	   
	   ObjectInputStream ois=new ObjectInputStream(s.getInputStream());	 
	   Message m=new Message();
	   m=(Message)ois.readObject();
	   if(m.getMsgType() == MessageType.Message_LoginSuccess)
	    {
		    ClientConnectServerThread ccst=new ClientConnectServerThread(s);
		    ccst.start();
		    ManageCCST.add(usrId, ccst);
		    nFlag=MessageType.Message_LoginSuccess;
	    }
	   else if(m.getMsgType() == MessageType.Message_LoginFail)
	    {
		    nFlag=MessageType.Message_LoginFail;
	    }
	   else if(m.getMsgType() == MessageType.Message_SCCTExisted)
	   {
		    nFlag=MessageType.Message_SCCTExisted;
	   }
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally{
         
   		} 
	return nFlag;
    }
    
}
