package com.qq.client.manage;

import java.util.*;
import java.net.*;

public class ManageCCST {
   
   static HashMap hm=new HashMap<String,ClientConnectServerThread>(); 
   static int nCountCCST=0;
   public static int getCountCCST()
   {
	   return nCountCCST;
   }
   public static void add(String Id,ClientConnectServerThread ccst)
   {
	   hm.put(Id, ccst);
	   nCountCCST++;
   }
   public static void remove(String Id)
   {
	   hm.remove(Id);
	   nCountCCST--;
   }
   public static ClientConnectServerThread get(String Id)
   {
	   return (ClientConnectServerThread)hm.get(Id);
   }
   public static String getActiveThread()
   {
 	  String szTemp="";
 	  Iterator i=hm.keySet().iterator();
 	  while(i.hasNext())
 	  {
          szTemp += i.next()+" ";
 	  }
 	  return szTemp;
   }
}
