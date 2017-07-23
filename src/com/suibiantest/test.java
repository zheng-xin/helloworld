package com.suibiantest;

import org.apache.commons.lang3.StringUtils;

public class test {
	public static void printStr(String str){
		if(StringUtils.isNotBlank(str)){
			for(int i=0;i<str.length();i++){
				if(str.length()>2){
					int k=(str.length()-1)*(str.length()-2);
					for(int j=0;j<k;j++){
						System.out.print(str.charAt(i));
						String s=str.substring(0, i)+str.substring(i+1, str.length());
						printStr(s);
					}
				}
				else{
					System.out.print(str.charAt(i));
					String s=str.substring(0, i)+str.substring(i+1, str.length());
					printStr(s);
				}
				
			}
		}
		else{
			System.out.println();
		}
	}
	public static void printStr2(String str){
		if(StringUtils.isNotBlank(str)){
			for(int i=0;i<str.length();i++){
					System.out.print(str.charAt(i));
					String s=str.substring(0, i)+str.substring(i+1, str.length());
					printStr(s);
				
			}
		}
		else{
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printStr2("ABCD");
		/*String str="abcdef";
		System.out.println(str.substring(0, 0)+str.substring(1,str.length()));*/
	}
}
