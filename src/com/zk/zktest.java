package com.zk;

import java.util.Arrays;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class zktest {
	public static final String ROOT = "/root-ktv";  
	  
	public static void main(String[] args) throws Exception {  
	    // 创建一个与服务器的连接  
	   ZooKeeper zk = new ZooKeeper("localhost:2181", 30000, new Watcher() {  
	        // 监控所有被触发的事件  
	        public void process(WatchedEvent event) {  
	            System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());  
	        }  
	    });  
	    // 创建一个总的目录ktv，并不控制权限，这里需要用持久化节点，不然下面的节点创建容易出错  
	    zk.create(ROOT, "root-ktv".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);  
	  
	    // 然后杭州开一个KTV ,       PERSISTENT_SEQUENTIAL 类型会自动加上 0000000000 自增的后缀  
	    zk.create(ROOT+"/KTV1", "KTV1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);  
	  
	    // 也可以在北京开一个,       EPHEMERAL session 过期了就会自动删除  
	    zk.create(ROOT+"/KTV2", "KTV2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  
	  
	    // 同理，我可以在北京开多个，EPHEMERAL_SEQUENTIAL  session 过期自动删除，也会加数字的后缀  
	    zk.create(ROOT+"/KTV3", "KTV3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);  
	  
	    zk.close();  
	    
	    
	    /**
	     * 
	     
	     
	     
	     ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 500000,new Watcher() {
           // 监控所有被触发的事件
             public void process(WatchedEvent event) {
           //dosomething
           }
      	});
		//创建一个节点root，数据是mydata,不进行ACL权限控制，节点为永久性的(即客户端shutdown了也不会消失)
		zk.create("/root", "mydata".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		//在root下面创建一个childone znode,数据为childone,不进行ACL权限控制，节点为永久性的
		zk.create("/root/childone","childone".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
		
		//取得/root节点下的子节点名称,返回List<String>
		zk.getChildren("/root",true);
		
		//取得/root/childone节点下的数据,返回byte[]
		zk.getData("/root/childone", true, null);
		
		//修改节点/root/childone下的数据，第三个参数为版本，如果是-1，那会无视被修改的数据版本，直接改掉
		zk.setData("/root/childone","childonemodify".getBytes(), -1);
		
		//删除/root/childone这个节点，第二个参数为版本，－1的话直接删除，无视版本
		zk.delete("/root/childone", -1);
		      
		//关闭session
		zk.close();
	     
	     
	     
	     
	     */
	    
	    
	    
	    
	    
	    
	    
	    
	}  
	
}
