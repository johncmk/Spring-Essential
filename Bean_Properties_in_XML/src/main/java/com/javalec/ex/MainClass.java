package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection conn = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("adminID: " + conn.getAdminId());
		System.out.println("adminPW: " + conn.getAdminPw());
		System.out.println("sub_adminID: " + conn.getSub_adminId());
		System.out.println("sub_adminPW: " + conn.getSub_adminPw());
		
		ctx.close();
		
	}//End Main

}//End Class
