package ru.alexraydev.javaspring02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");
		
		FruitBasket fruitBasket = context.getBean("basket", FruitBasket.class);
        System.out.println(fruitBasket);

        context.close();
	}

}
