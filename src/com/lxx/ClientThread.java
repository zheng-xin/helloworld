package com.lxx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread {

	private Socket socket;
	public ClientThread(Socket client) {
		this.socket=client;
	}
	@Override
	public void run() {
		try{
			InputStream serverIs=sendRequest(socket);
			OutputStream os=socket.getOutputStream();
			int len=0;
			byte[] buffer=new byte[1024];
			while((len=serverIs.read(buffer))>0){
				os.write(buffer,0,len);
				if(len<4)break;
				if(buffer[len-4]==13&&buffer[len-3]==10&&buffer[len-2]==13&&buffer[len-1]==10)
					break;
			}
			serverIs.close();
			os.close();
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public InputStream sendRequest(Socket sk) throws Exception, IOException{
		System.out.println("dsfsdfsdf");
		//Socket proxy=new Socket("127.0.0.1",8888);
		InputStream serverIs=null;//被代理服务器返回的数据流
		try {
			//OutputStream os=proxy.getOutputStream();
			int len=0;
			byte[] buffer=new byte[1024];
			byte[] end=new byte[4];
			int endNum=-1;
			byte[] endFlag=new byte[4];
			//处理请求数据
			while((len=sk.getInputStream().read(buffer))>0){
				System.out.println("len"+len);
				System.out.println("buffer:"+new String(buffer)+"<<<<<<end");
				//os.write(buffer, 0, len);
				sk.getOutputStream().write(buffer, 0, len);
				//处理EOF结束符被前后分开的情况
				if(len<4&&endNum>-1){
					switch (len) {
					case 1:
						endFlag[0]=end[1];endFlag[1]=end[2];endFlag[2]=end[3];endFlag[3]=buffer[0];
						break;
					case 2:
						endFlag[0]=end[2];endFlag[1]=end[3];endFlag[2]=buffer[0];endFlag[3]=buffer[1];
						break;
					case 3:
						endFlag[0]=end[3];endFlag[1]=buffer[0];endFlag[2]=buffer[1];endFlag[3]=buffer[2];
						break;
					default:
						break;
					}
				}else if(len>3){
					endFlag[3]=buffer[len-1];endFlag[2]=buffer[len-2];endFlag[1]=buffer[len-3];endFlag[0]=buffer[len-4];
					end[3]=buffer[len-1];end[2]=buffer[len-2];end[1]=buffer[len-3];end[0]=buffer[len-4];
					endNum=4;
				}
				if(endFlag[0]==13&&endFlag[1]==10&&endFlag[2]==13&&endFlag[3]==10)
					break;
			}
			//serverIs=proxy.getInputStream();
			//is.close();
			//os.close();
			//proxy.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serverIs;
	}
	
}
