package ru.alexraydev.javaspring05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans06.xml");
		
		Robot robot = (Robot)context.getBean("robot");
		
		robot.speak();
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
