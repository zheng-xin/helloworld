package com.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.user.action.messageListenser;

public class topicconsumer {
	public static void main(String[] args) throws JMSException {
		
		consumer();
		product();
	}
	public static void consumer(){
		 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
         try {  
              Connection connection = factory.createConnection();  
             connection.start();  
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
             Topic topic = session.createTopic("myTopic.messages"); 
             MessageConsumer consumer = session.createConsumer(topic);  
             System.out.println("ddd");
             messageListenser ml=new messageListenser();
             consumer.setMessageListener(ml);  
         } catch (JMSException e) {  
             e.printStackTrace();  
         }  
	}
	public static void product() throws JMSException{
		 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
         Connection connection = factory.createConnection();  
         connection.start();  
         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
         Topic topic = session.createTopic("myTopic.messages");  
         MessageProducer producer = session.createProducer(topic);  
         producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
         for(int i =0;i<10;i++){  
             TextMessage message = session.createTextMessage();  
             message.setText("message_" + i+":"+System.currentTimeMillis());  
             producer.send(message);  
             System.out.println("Sent message: " + message.getText());  
             try {  
                 Thread.sleep(1000);  
             } catch (InterruptedException e) {  
                 e.printStackTrace();  
             }  
         }  
     session.close();  
     connection.stop();  
     connection.close(); 
	}
}
