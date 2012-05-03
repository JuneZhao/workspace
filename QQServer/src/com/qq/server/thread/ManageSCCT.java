package com.qq.server.thread;

import java.util.*;
import java.net.*;
import java.io.*;
public class ManageSCCT {
      
	  static HashMap hm=new HashMap<String,ServerConnectClientThread>();
      static int nCountSCCT=0;
      public static int getCountSCCT()
      {
    	  return nCountSCCT;
      }
	  public static void add(String ownerId,ServerConnectClientThread scct)
      {
    	  hm.put(ownerId, scct);
    	  nCountSCCT++;
      }
	  
      public static ServerConnectClientThread get(String ownerId)
      {
    	  return (ServerConnectClientThread)hm.get(ownerId);
      }
      
      public static void remove(String ownerId)
      {
    	  hm.remove(ownerId);
    	  nCountSCCT--;
      }
      public static boolean isScctExisted(String ownerId)
      {
    	  boolean b=false;
    	  Iterator i=hm.keySet().iterator();
    	  while(i.hasNext())
    	  {
    		  if(i.next().equals(ownerId))
    		  {
    			  b=true;
    		      break;
    		  }
    	  }
    	  return b;
      }
      public static String getOnlineFriend()
      {
    	  String szTemp="";
    	  Iterator i=hm.keySet().iterator();
    	  while(i.hasNext())
    	  {
             szTemp += i.next()+" ";
             if(!i.hasNext())
             {
            	break; 
             }   
    	  }
    	  return szTemp;
      }
}
