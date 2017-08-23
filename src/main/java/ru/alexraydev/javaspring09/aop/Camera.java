package ru.alexraydev.javaspring09.aop;

import org.springframework.stereotype.Component;

@Component
public class Camera implements ICamera{

    public Camera() {
        System.out.println("Camera constructor");
    }

    public void snap() {
        System.out.println("SNAP!");
    }

    public void snap(int exposure) {
        System.out.println("SNAP! Exposure: " + exposure);
    }

    public String snap(String name) {
        System.out.println("SNAP! Name: " + name);
        return name;
    }

    public void snamNightTime() {
        System.out.println("SNAP! Night mode.");
    }
}
