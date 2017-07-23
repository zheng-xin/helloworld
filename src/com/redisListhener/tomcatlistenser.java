package com.redisListhener;

import java.util.List;
import redis.clients.jedis.Jedis;

public class tomcatlistenser {
public tomcatlistenser(){
	this.contextInitialized();
}
	public void contextInitialized() {
		new MyThread().start();
		new MyThread2().start();
		
	}
	 class   MyThread   extends   Thread
     {       int i;
             public   void   run()
             {  
            	 while(true){
     				@SuppressWarnings("resource")
     				Jedis jedis = new Jedis("localhost");  
     		        
					jedis.lpush("redisChatTest","我是"+String.valueOf(i));  
     		        i++;
     		        if(i==10000) break;
     		}
           }
     } 
	 class   MyThread2   extends   Thread
     {
             public   void   run()
             {
            	 Jedis jds = new Jedis("localhost");  
         		 while(true){
         			List<String> s = jds.blpop("redisChatTest","1");
         			if(s!=null){
         				System.out.println(s.get(1));
         			}
         		}
             }
     } 
}
