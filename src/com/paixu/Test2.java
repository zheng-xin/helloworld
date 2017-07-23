package com.paixu;

public class Test2 {
	public static Long getResult1(int i) throws Exception{
		Long sum=1l;
		if(i<0) throw new IndexOutOfBoundsException();
		if(i==1){ return 1l;}
		else{
			sum=i*getResult1(i-1);
			return sum;
		}
	
	};
	public static Long getResult2(int i) throws Exception{
		Long result=1l;
		for(int j=1;j<=i;j++){
			result=j*result;
		}
	return result;
	};
	public static void main(String[] args) throws Exception {
		
	}
}
