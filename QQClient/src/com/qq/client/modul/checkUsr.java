package com.qq.client.modul;
import java.net.*;
import java.io.*;
import com.qq.common.*;
import com.qq.client.usrcheck.*;
public class checkUsr{
    public int check(Usr usr)
    {
       ClientUsrCheck quc=new ClientUsrCheck();
       return quc.SendLoginInfoToServer(usr.getUsrId(), usr.getPassword());  	
    }
}
