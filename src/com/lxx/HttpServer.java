package com.lxx;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class HttpServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
			try {
			ServerSocket server=new ServerSocket(8888,50,InetAddress.getByName("127.0.0.1"));
			while(true){
				Socket client=server.accept();
				System.out.println("ssssddddd");
				System.out.println("client:"+client);
				ClientThread thread=new ClientThread(client);
				thread.start();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	
	
}
