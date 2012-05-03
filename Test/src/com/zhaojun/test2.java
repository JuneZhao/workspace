package com.zhaojun;

import java.util.Calendar;

public class test2 {

	public static void main(String []args)
	{
//		int nLen=8000000;
//		int arr[]=new int[nLen];
//		for(int i=0;i<nLen;++i)
//		{
			//让程序随机产生一个1-10000的数
//			int t=(int)(Math.random()*10000);
//			arr[i]=t;
//		}
		//在排序前打印系统时间
		int arr[]={0,9,8,7,6,5,-1,3};
		Calendar cal=Calendar.getInstance();//单态模式
        System.out.println(cal.getTime());
//		new Bubble(arr);
//      new Selection(arr);
//      new Insertion(arr);
     BinaryFind bf=new BinaryFind();
      System.out.println(bf.sortandsearch(arr,8));
		cal=Calendar.getInstance();
		System.out.println(cal.getTime());

		for(int i=0;i<arr.length;++i)
		System.out.println(arr[i]);
		
//		System.out.println(index);
	}
}
/*class Generic<T>
{
	Generic(T t)
	{
		
	}
}
*/
 
class BinaryFind
{
	private int index;
	public BinaryFind()
	{
		index=0;
	}
	//先快速排序，接着二分法查找
	public int sortandsearch(int a[],int K)
	{	
		int left=0;
	    int right=a.length-1;
	    while(a[index] != K && index<a.length-1)	    
	    	index++;
	    quicksort(left,right,a);
	    int numPos=search(left,right,K,a);
		return numPos;	
	}
	public void quicksort(int left,int right,int a[])
	{		
//    if(left<right)
//	{
    int i=left,j=right;
	int midVal=a[(left+right)/2];
	int tempVal;
	
	while(i<j)
	{  
		while(a[j]>midVal && j>left)
			j--;
/*		if(j>left)
		{		
			tempVal=a[j];
			a[j]=a[i];
			a[i]=tempVal;
		}
		*/
		while(a[i]<midVal && i<right)
			i++;
/*		if(i<right)
		{
			tempVal=a[i];
			a[i]=a[j];
			a[j]=tempVal;	
		}
		*/
/*		if(i<j)
		{
			tempVal=a[i];
			a[i]=a[j];
			a[j]=tempVal;
		}
*/		
	}
//	if(a[i] == a[j])
//  {
//		return;
//		i++;
//		j--;
//	}
	if(i == j)
	{
		quicksort(i+1,right,a);
	    quicksort(left,j-1,a);	
	}
	else return;
//	}
//   else return;
	}
/*	public int search(int leftPos,int rightPos,int searchofNum,int a[])
	{
		int left=leftPos;
		int right=rightPos;
		int numPos=(left+right)/2;
		int temp=a[numPos];
		
		if(left<=right)
		{
			if(temp < searchofNum)
			{
				left=numPos+1;
				return search(left,right,searchofNum,a);
			}
			if(temp > searchofNum)
			{
				right=numPos-1;
				return search(left,right,searchofNum,a);
			}
			if(temp == searchofNum)
			{
				return numPos;
			}
		}
		return -1;	
		
	  }
*/
	public int search(int leftPos,int rightPos,int searchofNum,int a[])
	{
		int left=leftPos;
		int right=rightPos;
		int numPos=(left+right)/2;
		
	    while(left<=right)
	   {
	    	  numPos = (left+right)/2;

	            //如果等于key,返回这个数在数组中的位置.

	            if(a[numPos]==searchofNum)

	                return index;

	            //如果大于key,则在左边.

	            if(a[numPos]>searchofNum)

	            	right = numPos-1;

	            //如果小于key,则在右边

	            if(a[numPos]<searchofNum)

	            	left = numPos+1;

	    }
	    return -1;
	 }

}