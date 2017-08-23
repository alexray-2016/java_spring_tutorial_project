package ru.alexraydev.javaspring09.aop;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public void start() {
        System.out.println("Car starting");
    }

    public void start(int i, int k) {

    }
}
