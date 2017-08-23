package ru.alexraydev.javaspring09.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans09.xml");

        ICamera camera = context.getBean("camera", ICamera.class);
        Car car = context.getBean("car", Car.class);

        camera.snap();
        car.start();
        car.start(3, 5);
        context.close();
    }
}
