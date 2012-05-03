package com.test;
import java.io.*;
public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
       Father f=new Father();
       f.test1();
	}

}

class Father
{
	private Son son=null;
	Father()
	{
		son =new Son();
	}
	public void test1() throws Exception
	{
//		try{
		son.test2();
//		}catch(Exception e){
//			System.out.println("Father");
//			e.printStackTrace();
//		}
	}
}
class Son
{
	public void test2() throws Exception
	{
		FileReader fr=null;
		fr=new FileReader("d:\\dd.txt");
	}
}