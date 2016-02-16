package com.javalec.ex;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String config = null;
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		
		if(str.equals("dev")) {
			config = str;
		} else if(str.equals("run")) {
			config = str;
		}
		
		scanner.close();

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP: " + info.getIpNum());
		System.out.println("PORT: " + info.getPortNum());
		ctx.close();
		
	}//End Main
}//End Class
