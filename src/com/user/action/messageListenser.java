package com.user.action;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class messageListenser implements MessageListener{

	@Override
	 public void onMessage(Message message) {  
   	 System.out.println("ssss");
        TextMessage tm = (TextMessage) message;  
        try {  
            System.out.println("Received message: " + tm.getText());  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
    }  

}
