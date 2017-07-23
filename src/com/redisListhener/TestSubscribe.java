package com.redisListhener;

import redis.clients.jedis.Jedis;

public class TestSubscribe {
	 @SuppressWarnings("resource")
	public void testSubscribe() throws Exception{  
	        Jedis jedis = new Jedis("localhost");  
	        RedisMsgPubSubListener listener = new RedisMsgPubSubListener();  
	        jedis.subscribe(listener, "redisChatTest");  
	        //other code  
	    }  
	 public static void main(String[] args) throws Exception {
		 TestSubscribe ts = new TestSubscribe();
		 ts.testSubscribe();
	}
}

