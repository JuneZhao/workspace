package com.zhaojun;
import java.util.*;
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  ArrayList al=new ArrayList();
      Computer c1=new Computer(3,"惠普");
      Camera c2=new Camera(4,"柯达");
      Person p1=new Person("小强",c1);
      Person p2=new Person("小明",c2);
      p1.use(c1);
      p2.use(c2);
//    p1.setdeviceusbState();
//    p1.useDevice(); 
//    p2.useDevice();
 //   p1.ownedDevice(c1);
 //   p2.ownedDevice(c2);
      al.add(p1);
      al.add(p2);
      for(int i=0;i<al.size();++i)
    	  ((Person)al.get(i)).ownedDevice();
	}
}
interface Usb
{
	final static int a=1;
	public String use();
	public String set();
}

class Device implements Usb
{
	 int usedYear;
     String name;
     public String use() {
		// TODO Auto-generated method stub
		return "";
	}
	public String set() {
		// TODO Auto-generated method stub
		return "";
	}
     public String getName()
     {
    	 return " ";
 //   	 return name;
     }
     public int getusedYear()
     {
    	 return 0;
//    	 return usedYear;
     }
}
class Computer extends Device
{  
	int nflagInterface;
	Computer(int usedYear,String name)
	{
		this.usedYear = usedYear;
		this.name = name;
		nflagInterface = 0;
	}
    public String use()
    {// TODO Auto-generated method stub
    	if(nflagInterface == 1)
    	   return "电脑可以使用usb接口了";
    	else
    	   return "电脑未设置接口，请先设置接口！";
    }
    public String set()
    {// TODO Auto-generated method stub
    	nflagInterface = 1;
    	 return  "成功设置了电脑usb接口";
    }
    @Override
    public String getName()
    {// TODO Auto-generated method stub
    	return name;
    }
    
    public int getusedYear()
    {// TODO Auto-generated method stub
    	return usedYear;
    }
}

class Camera extends Device
{
	int nflagInterface;
    Camera(int usedYear,String name)
    {
    	this.name = name;
    	this.usedYear = usedYear;
    	nflagInterface=0;
    }
	public String use() {
		// TODO Auto-generated method stub
    	if(nflagInterface == 1)
     	   return "照相机可以使用usb接口了";
    	else
		   return "照相机未设置接口，请先设置接口！";
	}

	public String set() {
		// TODO Auto-generated method stub
		nflagInterface = 1;
		return "成功设置了照相机usb接口";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
    public int getusedYear()
    {// TODO Auto-generated method stub
    	return usedYear;
    }
}

class Person
{
	String name;
	Device dc;
	Person(String name,Device dc)
	{
		this.name = name;
		this.dc =dc;
	}
	public void ownedDevice()
	{
		String deviceName = dc.getName();
		int usedYear= dc.getusedYear();
		System.out.println(name+"拥有的设备是"+deviceName+",已经用了"+usedYear+"年");
	}
	public void setdeviceusbState()
	{
		System.out.println(name+dc.set());
	}
	public void useDevice()
	{
		System.out.println(name+",你的"+dc.use());
	}
	public void use(Usb usb)
	{
		System.out.println(name+",你的"+usb.use());
	}
}