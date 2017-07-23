package com.redisListhener;

import redis.clients.jedis.JedisPubSub;

public class RedisMsgPubSubListener extends JedisPubSub {

	/**
	 *监听到订阅模式接受到消息时的回调 (onPMessage)
	 *监听到订阅频道接受到消息时的回调 (onMessage )
	 *订阅频道时的回调( onSubscribe )
	 *取消订阅频道时的回调( onUnsubscribe )
	 *订阅频道模式时的回调 ( onPSubscribe )
	 *取消订阅模式时的回调( onPUnsubscribe )
	 */
	@Override
	public void onMessage(String arg0, String arg1) {
		System.out.println("onmessage:"+arg0+":"+arg1);
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		System.out.println("onPMessage:"+arg0+":"+arg1);
		
	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		System.out.println("onPSubscribe:"+arg0+":"+arg1);
		
	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
		System.out.println("onPUnsubscribe:"+arg0+":"+arg1);
	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		System.out.println("onSubscribe:"+arg0+":"+arg1);
		
	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		System.out.println("onUnsubscribe:"+arg0+":"+arg1);
		
	}

}
