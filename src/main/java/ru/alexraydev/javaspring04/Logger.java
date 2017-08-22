package ru.alexraydev.javaspring04;

/*
 * Dummy implementation of logger.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

    //@Autowired
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

    //@Autowired
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
        if (consoleWriter != null) {
            consoleWriter.write(text);
        }
	}

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

}
