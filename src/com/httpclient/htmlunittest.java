package com.httpclient;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class htmlunittest {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

	final WebClient webClient=new WebClient();
	final HtmlPage page=webClient.getPage("https://www.baidu.com/index.php?tn=monline_3_dg");
	//System.out.println(page.asText());
	System.out.println(page);
	webClient.close();

	}
}
