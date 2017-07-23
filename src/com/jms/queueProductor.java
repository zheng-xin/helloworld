package com.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class queueProductor {
	public static void main(String[] args) throws Exception {
		String jmsProviderAddress = "tcp://localhost:61616";// 地址 
		 
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( 
                jmsProviderAddress);// 连接器 
 
         Connection connection = connectionFactory.createConnection();// 创建连接 
 
        Session session = connection.createSession(false, 
                Session.AUTO_ACKNOWLEDGE);// 打开会话 
 
        Destination dest = session.createQueue("demoQueue");// 消息目的地 
 
        MessageProducer producer = session.createProducer(dest);// 消息发送者 
 
        Message message = session.createTextMessage("hello jms");// 消息 
 
        producer.send(message);// 发送 
 
        producer.close();// 关闭 
        session.close(); 
        connection.close();  
	}
}
