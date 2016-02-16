package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("Name: " + student1.getName());
		System.out.println("Age: " + student1.getAge());
		
		System.out.println("====================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("Tom");
		student2.setAge(100);

		System.out.println("Name: " + student1.getName());
		System.out.println("Age: " + student1.getAge());
		
		System.out.println("====================");

		
		/**
		 * In the spring bean configurations, bean attribute called 'scope' defines what kind of object has to created and returned. 
		 * There are 5 types of bean scopes available, they are:

			1) singleton: Returns a single bean instance per Spring IoC container.
			
			2) prototype: Returns a new bean instance each time when requested.
			
			3) request: Returns a single instance for every HTTP request call.
			
			4) session: Returns a single instance for every HTTP session.
			
			5) global session: global session scope is equal as session scope on portlet-based web applications.
			
			If no bean scope is specified in bean configuration file, then it will be by default 'singleton'.
			
			- See more at: http://www.java2novice.com/spring/bean-scope-types/#sthash.sHsVfR6R.dpuf
		 */
		
		/**
		 * The object student1 and student2 are pointing to the same reference because the xml scope is set to 
		 * singleton. Therefore if the property of the student2 is changed so does the property of student1 changes as well.
		 */
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}
		
		ctx.close();
	}//End Main
}//End Class
