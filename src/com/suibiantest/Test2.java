package com.suibiantest;

import java.util.Scanner;

public class Test2 {
	 public static void main(String[] args) { 

	        String str = "asd"; 
	        permutation(str.toCharArray(), 0); 

	    } 

	  

	    public static void permutation(char[] str, int i) { 

	        if (i >= str.length) 

	            return; 

	        if (i == str.length - 1) { 

	            System.out.println(String.valueOf(str)); 

	        } else { 

	            for (int j = i; j < str.length; j++) { 

	                char temp = str[j]; 

	                str[j] = str[i]; 

	                str[i] = temp; 

	  

	                permutation(str, i + 1); 

	  

	                temp = str[j]; 

	                str[j] = str[i]; 

	                str[i] = temp; 

	            } 

	        } 

	    }
}
