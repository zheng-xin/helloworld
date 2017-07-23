package com.zk;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class test {
	public static final String ROOT = "/root-ktv";  
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		  ZooKeeper zk = new ZooKeeper("localhost:2181", 30000, new Watcher() {  
		        // 监控所有被触发的事件  
		        public void process(WatchedEvent event) {  
		            System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());  
		        }  
		    });
		  List<String> ktvs = zk.getChildren(ROOT, true);  
		    System.out.println(Arrays.toString(ktvs.toArray())+"end");  
		    for(String node : ktvs){  
		        // 删除节点  
		        zk.delete(ROOT+"/"+node,-1);  
		    }  
		    // 根目录得最后删除的  
		    zk.delete(ROOT, -1);  
		    zk.close();  
		    
	}
}	
