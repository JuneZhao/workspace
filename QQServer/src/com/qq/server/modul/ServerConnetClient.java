package com.qq.server.modul;

import java.net.*;
import java.io.*;
import java.util.*;
import com.qq.common.*;
import com.qq.server.thread.*;
public class ServerConnetClient{
    ObjectOutputStream oos;
	public ServerConnetClient()
	{
		try {
			ServerSocket ss=new ServerSocket(999);
			while(true)
			{	
				//��������
				Socket s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				String st=new String();
				st=(String)ois.readObject();
	            
				String []sTemp=st.split(" ");
				System.out.println(sTemp[0]+"������");
				if(sTemp[1].equals("123") && ! ManageSCCT.isScctExisted(sTemp[0]))
				{	
					ServerConnectClientThread scct=new ServerConnectClientThread(s);
					scct.start();
					ManageSCCT.add(sTemp[0],scct);
								
					oos=new ObjectOutputStream(s.getOutputStream());
					Message m=new Message();
					m.setMsgType(MessageType.Message_LoginSuccess);
					oos.writeObject(m);
												
                    scct.notifyAll(sTemp[0]);
				}
				else if(!sTemp[1].equals("123"))
				{
					oos=new ObjectOutputStream(s.getOutputStream());
					Message m=new Message();
					m.setMsgType(MessageType.Message_LoginFail);
					oos.writeObject(m);
				}
				else if(ManageSCCT.isScctExisted(sTemp[0]))
				{
					oos=new ObjectOutputStream(s.getOutputStream());
					Message m=new Message();
					m.setMsgType(MessageType.Message_SCCTExisted);
					oos.writeObject(m);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("error");
		}
	}

}