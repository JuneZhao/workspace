package com.qq.client.manage;

import java.util.*;
import com.qq.client.view.*;

public class ManageQqChat {
   public static HashMap hm=new HashMap<String,QqChat>();
   
   public static void add(String IdFromAndTo,QqChat qc)
   {
	   hm.put(IdFromAndTo, qc);
   }
   public static QqChat get(String IdFromAndTo)
   {
	   return (QqChat)hm.get(IdFromAndTo);
   }
   public static boolean isQqChatExist(String IdFromAndTo)
   {
	   boolean b=false;
	   Iterator i=hm.keySet().iterator();
	   while(i.hasNext())
	   {
		   if(i.next().equals(IdFromAndTo))
		   {
			   b=true;
			   break;
		   }
	   }
		   
	   return b;
   }
   
}
