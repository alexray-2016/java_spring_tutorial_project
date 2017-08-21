package ru.alexraydev.javaspring05;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private String id = "Default robot";
	private String speech = "hello";
	
	public void speak() {
		System.out.println(id + ": " + speech);
	}

    @Autowired
	public void setId(@Value("#{new java.util.Random().nextInt(1000)}") String id) {
		this.id = id;
	}

    @Autowired
	public void setSpeech(@Value("#{T(Math).PI}")String speech) {
		this.speech = speech;
	}
	
	
}
