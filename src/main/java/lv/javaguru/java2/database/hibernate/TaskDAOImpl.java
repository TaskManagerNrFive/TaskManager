package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.TaskComment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by NightStranger on 6/5/2016.
 */
@Component("ORM_TaskDAO")
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(Task user) throws DBException {
        throw new DBException("Error!");
    }

    @Override
    public void create(Task task) throws DBException {
        throw new DBException("Error!");
    }

    @Override
    public void delete(int id) throws DBException {
        throw new DBException("Error!");
    }

    @Override
    public Task getById(int id) throws DBException {
        throw new DBException("Error!");
    }

    @Override
    public List<Task> getAll() throws DBException {
        throw new DBException("Error!");
    }

    @Override
    public List<Task> getAllTasksByUserId(int userId) throws DBException {
        throw new DBException("Error!");
    }

    @Override
    public List<Task> getFilteredList(long userId, long teamId,
                                      long status, String title) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Task.class);
        criteria.createAlias("user", "u");
        if (userId != 0) {
            criteria.add(Restrictions.eq("u.userId", userId));
        }
        if (teamId != 0) {
            criteria.add(Restrictions.eq("u.teamId", teamId));
        }

        if (status == 1) {
            criteria.add(Restrictions.isNull("doneDate"));
        }
        else if (status == 2) {
            criteria.add(Restrictions.isNotNull("doneDate"));
        }
        if (title.length() > 0) {
            criteria.add(Restrictions.ilike("title", title, MatchMode.START));
        }
        return criteria.list();
    }

}
