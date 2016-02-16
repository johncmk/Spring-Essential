package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String config = "classpath:applicationCTX.xml"; // Config location
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		MyInfo mi = ctx.getBean("myInfo", MyInfo.class);
		System.out.println(mi.toString());
		ctx.close();
		
	}//End main

}//End Class
