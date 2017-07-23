package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class ListTest {
	public static void main(String[] args) {
		List arraytlist=new ArrayList<>();
		List linklist=new LinkedList<>();
		List lista=getList(arraytlist);
		List listl=getList(linklist);
		Long start=System.currentTimeMillis();
		removeList2(lista);
		Long end=System.currentTimeMillis();
		System.out.println(end-start);
		Long start2=System.currentTimeMillis();
		removeList(listl);
		Long end2=System.currentTimeMillis();
		System.out.println(end2-start2);
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("a", "a");
		map.put("b", "b");
		Iterator<java.util.Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			 java.util.Map.Entry<String, String> va = it.next();
		}
	}
	public static List getList(List list){
		for(int i=0;i<10000;i++){
			list.add(i);
		}
		return list;
	}
	public static void removeList(List list){
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			it.next();
			it.remove();
		}
	}
	public static void removeList2(List list){
		for(int i=0;i<list.size();i++){
			list.remove(i);
		}
	}
}
