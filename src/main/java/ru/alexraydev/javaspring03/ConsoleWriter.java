package ru.alexraydev.javaspring03;

public class ConsoleWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);
	}

}
