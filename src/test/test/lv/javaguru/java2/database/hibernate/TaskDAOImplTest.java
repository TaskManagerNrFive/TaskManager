package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.database.jdbc.*;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.SpringAppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by NightStranger on 6/8/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAppConfig.class)
@WebAppConfiguration

public class TaskDAOImplTest {

    @Autowired
    private DatabaseDataCleaner databaseDataCleaner;

    @Autowired
    @Qualifier("ORM_TaskDAO")
    private TaskDAO taskDAO;

    /* Mock? */
    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @Autowired
    TestUtilities testUtilities;

    @Before
    public void init() throws DBException {
        databaseDataCleaner.cleanDatabase();
    }

    @Test
    @Transactional
    public void createTask() throws DBException {
        User user = testUtilities.createUser("F", "L", "Email", "Login", "Password", 0L);
        userDAO.create(user);
        Task task = testUtilities.createTask(null, Date.valueOf("2016-05-10"),
                                             "New Task", user.getUserId(),
                                             user.getUserId());
        taskDAO.create(task);
        Task newTask = taskDAO.getById(task.getTaskId());
        assertNotNull(newTask);
        assertEquals(task.getTaskId(), newTask.getTaskId());
        assertEquals(task.getDoneDate(), newTask.getDoneDate());
        assertEquals(task.getUserId(), newTask.getUserId());
    }

}