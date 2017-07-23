package com.user.action;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="/system/jms")
public class jmstest implements MessageListener{
	@RequestMapping(value="/send.do")
	public void test() throws JMSException, NamingException {
		  InitialContext context = new InitialContext();

          // lookup the queue object
          Queue queue = (Queue) context.lookup("java:comp/env/queue/queue0");

          // lookup the queue connection factory
          QueueConnectionFactory conFactory = (QueueConnectionFactory) context
                  .lookup("java:comp/env/queue/connectionFactory");

          // create a queue connection
          QueueConnection queConn = conFactory.createQueueConnection();

          // create a queue session
          QueueSession queSession = queConn.createQueueSession(false,
                  Session.DUPS_OK_ACKNOWLEDGE);

          // create a queue sender
          QueueSender queSender = queSession.createSender(queue);
          queSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

          // create a simple message to say "Hello World"
          TextMessage message = queSession.createTextMessage("Hello World");
          System.out.println("哈哈哈哈");
          // send the message
          queSender.send(message);
	}
	@RequestMapping(value="/resive.do")
	public  void resive(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
		 // get the initial context
        InitialContext context = new InitialContext();

        // lookup the queue object
        Queue queue = (Queue) context.lookup("java:comp/env/queue/queue0");

        // lookup the queue connection factory
        QueueConnectionFactory conFactory = (QueueConnectionFactory) context
                .lookup("java:comp/env/queue/connectionFactory");

        // create a queue connection
        QueueConnection queConn = conFactory.createQueueConnection();

        // create a queue session
        QueueSession queSession = queConn.createQueueSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // create a queue receiver
        QueueReceiver queReceiver = queSession.createReceiver(queue);

        // start the connection
        queConn.start();

        // receive a message
        TextMessage message = (TextMessage) queReceiver.receive();
        // print the message
        response.getWriter().write("Message Received: " + message.getText());
        System.out.println("接受消息");
        // close the queue connection
        //queConn.close();
	}
	@Override
	public void onMessage(Message msg) {
		 if (msg instanceof TextMessage) {

             //把Message 转型成 TextMessage 并提取消息内容
			 System.out.println("listener");
             try {
				String msgTxt = ((TextMessage) msg).getText();

				 System.out.println("HelloSubscriber got message: " +

				     msgTxt);
			} catch (JMSException e) {
				e.printStackTrace();
			}

          }
		
	}
}
