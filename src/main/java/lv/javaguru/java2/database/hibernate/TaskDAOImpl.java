package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by NightStranger on 6/5/2016.
 */
@Component("ORM_TaskDAO")
@Transactional
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(Task task) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public void create(Task task) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(task);
    }

    @Override
    public void delete(long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        Task task = (Task) session.get(Task.class, id);
        session.delete(task);
    }

    @Override
    public Task getById(long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Task) session.get(Task.class, id);
    }

    @Override
    public List<Task> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Task.class).list();
    }

    @Override
    public List<Task> getAllTasksByUserId(long userId) throws DBException {
        return getFilteredList(userId, 0, 0, "");
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
