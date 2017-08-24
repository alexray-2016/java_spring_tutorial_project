package ru.alexraydev.javaspring07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import ru.alexraydev.javaspring07.dao.Offer;
import ru.alexraydev.javaspring07.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;
	
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void createOffer(Offer offer) {
        offersDao.create(offer);
    }
}
