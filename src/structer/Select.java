package structer;

import java.util.Scanner;

public class Select {
	public static void main(String[] args) {
		long starttime=System.currentTimeMillis();
		System.out.println("输入生成随机数组大小");
		Scanner can=new Scanner(System.in);
		int i=can.nextInt();
		System.out.println("i = "+i);
		int k=i/2;
		int [] arr=new int [i];
		arr=arrayRandom(i);
		int a = sortable(arr,k);
		long endtime=System.currentTimeMillis();
		long time=endtime-starttime;
		System.out.println(a);
		System.out.println("程序运行时间为"+time+"毫秒");
	}
	
	public static int[] arrayRandom(int i) {
		int[] arr=new int[i];
		//���߿����ñ�ķ��� Random ran=new Random();�ο���https://blog.csdn.net/qq_41516626/article/details/81300017
		for (int j=0;j<i;j++)
		{
			int temp=(int)(Math.random()*100)+1;
			arr[j]=temp;
		}
		for(int j=0;j<arr.length;j++) {
		System.out.print(arr[j]+" ");}
		System.out.println(" ");
			return arr;
	}	
	
	public static int sortable(int[] arr,int k) {
		int temp = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i = 0; i< arr.length; i++) {
			System.out.print("排序后");
			System.out.print(arr[i]);
			System.out.println("");
		}
		return arr[k];
	}
}
