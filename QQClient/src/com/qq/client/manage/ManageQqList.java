package com.qq.client.manage;

import java.util.*;
import com.qq.client.view.*;
public class ManageQqList {
   public static HashMap hm=new HashMap<String,QqList>();
   public static void addQqList(String ownerId,QqList qqList)
   {
	   hm.put(ownerId, qqList);
   }
   public static QqList getQqList(String ownerId)
   {
	   return (QqList)hm.get(ownerId);
   }
}
