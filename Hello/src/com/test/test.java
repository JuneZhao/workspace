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
		//����쳣
		//�쳣���� try...catch...finally
		FileReader fr=null;
		try{
			fr=new FileReader("d:\\aa.txt");// �ų��쳣��ֱ�ӽ��뵽�쳣������ִ����������
			Socket s=new Socket("192.168.1.3",78);
		}catch(FileNotFoundException e){
			//���쳣����Ϣ���,�����ų�bug
			e.printStackTrace();
			//����
		}catch(ConnectException e){
			e.printStackTrace();
		    System.out.println(e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//������飬������û���쳣������ִ��
			//һ��˵������Ҫ�رյ���Դ[�ļ������ӣ��ڴ档����]�ŵ�����
			if(fr != null)
				{
				System.out.println("����Finally");
				try{
					fr.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				     
				}
		}
		
		//2.����һ��192.168.12.12 ip�Ķ˿ں�
        //Socket s=new Socket("192.168.1.3",78);
		
		//�����쳣

}
