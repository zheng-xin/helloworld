package com.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.user.action.messageListenser;

public class topicconsumer2 {
	ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616"); 
	public topicconsumer2() throws JMSException{
		 Connection connection = factory.createConnection();  
         connection.start();  
         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
         Topic topic = session.createTopic("myTopic.messages"); 
         MessageConsumer consumer = session.createConsumer(topic);  
         System.out.println("ddd");
         messageListenser ml=new messageListenser();
         consumer.setMessageListener(ml);  
	}
}
