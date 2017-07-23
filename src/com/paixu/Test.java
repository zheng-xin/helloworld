package com.paixu;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
//		int[] shus={88,45,2,23,67,33,337,55,77,76,43,87};
//		int[] shus2={1,9,8,6,5,7,3,2,0};
//		List list=new LinkedList<String>();
//		Iterator it = list.iterator();
//		StringBuffer sb=new StringBuffer();
//		it.hasNext();
		System.out.println(recursion(4));
	}
	public void maopao(int shus[]){
		long t1=System.currentTimeMillis();
		for(int i=0;i<shus.length-1;i++){
			for(int j=i+1;j<shus.length;j++){
				if(shus[i]>shus[j]){
					int temp=shus[i];
					shus[i]=shus[j];
					shus[j]=temp;
				}
			}
		}
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1+Arrays.toString(shus));
	}
	public static int[] quickSort(int[] numbers, int start, int end) {   
	   int low=start;
	   int high=end;
	   int temp=numbers[start];
	   if(low<high){  
		   while(low<high){
			   while(low<high&&numbers[high]>=temp)high--;
			   if(low<high){
				 numbers[low]=numbers[high];
				 low++;
			   }
			   while(low<high&&numbers[low]<=temp)low++;
			   if(low<high){
				   numbers[high]=numbers[low];
				 high--;
			   }
		  
	   }
	   numbers[low]=temp;
		   quickSort(numbers, start, low-1);
		   quickSort(numbers, low+1, end);
	   }
	return null;
	}  
	 public static int recursion(int num){//利用递归计算阶乘

	        int sum=1;

	        if(num < 0)

	            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常

	        if(num==1){

	            return 1;//根据条件,跳出循环

	        }else{

	            sum=num * recursion(num-1);//运用递归计算

	            return sum;

	        }

	    }

}
