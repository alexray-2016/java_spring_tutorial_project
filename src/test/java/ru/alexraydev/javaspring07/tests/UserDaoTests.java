package ru.alexraydev.javaspring07.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.alexraydev.javaspring07.dao.User;
import ru.alexraydev.javaspring07.dao.UsersDAO;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:offers_config/dao-context.xml",
        "classpath:offers_config/security-context.xml",
        "classpath:offers_config/tests/test-datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

    @Autowired
    private UsersDAO usersDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.execute("delete from users");
        jdbc.execute("delete from authorities");
    }

    @Test
    public void testCreateUser() {
        User user = new User("alexander", "hellothere", "alex@gmail.com", true, "ROLE_USER");
        assertTrue("User creation should return true", usersDao.create(user));

        List<User> users = usersDao.getAllUsers();

        assertEquals("Nubmer of users should be 1", 1, users.size());

        assertTrue("User should exist", usersDao.exists(user.getUsername()));

        assertEquals("Created user must be identical to retrieved", user, users.get(0));
    }
}
