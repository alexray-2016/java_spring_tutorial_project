package ru.alexraydev.javaspring07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexraydev.javaspring07.dao.Offer;
import ru.alexraydev.javaspring07.dao.OffersDAO;

import java.util.List;

@Service("offersService")
public class OffersService {

    @Autowired
    private OffersDAO offersDAO;

    public List<Offer> getCurrent() {
        return offersDAO.getOffers();
    }
}
