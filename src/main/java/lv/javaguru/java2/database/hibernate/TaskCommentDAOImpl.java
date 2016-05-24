package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskCommentDAO;
import lv.javaguru.java2.domain.TaskComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by NightStranger on 5/24/2016.
 */

@Component("ORM_TaskCommentDAO")
@Transactional
public class TaskCommentDAOImpl implements TaskCommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(TaskComment taskComment) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(taskComment);
    }

    @Override
    public List<TaskComment> getByTaskID(int taskID) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TaskComment.class)
                .add(Restrictions.eq("taskID", taskID))
                .addOrder(Order.desc("createTimeStamp"))
                .list();
    }

}
