package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection conn = ctx.getBean("adminConfig", AdminConnection.class);
		
		System.out.println("AdminID: " + conn.getAdminId());
		System.out.println("AdminPW: " + conn.getAdminPw());
		System.out.println("sub_AdminID: " + conn.getSub_adminId());
		System.out.println("sub_AdminPW: " + conn.getSub_adminPw());
		
		ctx.close();
		
	}//End Main

}//End Class
