package ru.alexraydev.javaspring06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans06.xml");

        OffersDAO offersDAO = context.getBean("offersDao", OffersDAO.class);

        Offer offer = new Offer(4, "Claire", "claire@gmail.com", "Web design to fit any budget");

        for (Offer o : offersDAO.getOffers()) {
            System.out.println(o);
        }
        offersDAO.update(offer);
        for (Offer o: offersDAO.getOffers()) {
            System.out.println(o);
        }
        ((ClassPathXmlApplicationContext) context).close();
	}

}
