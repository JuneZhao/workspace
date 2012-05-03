package com.test;
import java.io.*;
import java.net.*;
public class test {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//检查异常
		//异常处理 try...catch...finally
		FileReader fr=null;
		try{
			fr=new FileReader("d:\\aa.txt");// 排除异常后直接进入到异常处理，不执行下面的语句
			Socket s=new Socket("192.168.1.3",78);
		}catch(FileNotFoundException e){
			//把异常的信息输出,利于排除bug
			e.printStackTrace();
			//处理
		}catch(ConnectException e){
			e.printStackTrace();
		    System.out.println(e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//这个语句块，不管有没有异常，都会执行
			//一般说，把需要关闭的资源[文件，链接，内存。。。]放到这里
			if(fr != null)
				{
				System.out.println("进入Finally");
				try{
					fr.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				     
				}
		}
		
		//2.链接一个192.168.12.12 ip的端口号
        //Socket s=new Socket("192.168.1.3",78);
		
		//运行异常

}
