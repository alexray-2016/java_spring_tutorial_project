package ru.alexraydev.javaspring07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import ru.alexraydev.javaspring07.dao.Message;
import ru.alexraydev.javaspring07.dao.MessagesDao;
import ru.alexraydev.javaspring07.dao.User;
import ru.alexraydev.javaspring07.dao.UsersDao;

@Service("usersService")
public class UsersService {

    @Autowired
	private UsersDao usersDao;

    @Autowired
    private MessagesDao messagesDao;
	
	public void create(User user) {
		usersDao.create(user);
	}


	public boolean exists(String username) {
		return usersDao.exists(username);
	}

    public void sendMessage(Message message) {
        messagesDao.saveOrUpdate(message);
    }

    public User getUser(String username) {
        return usersDao.getUser(username);
    }

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}

    public List<Message> getMessages(String username) {
        return messagesDao.getMessages(username);
    }
}
