package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.TaskType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrew on 4/19/16.
 */
@Component("ORM_TaskTypeDAO")
@Transactional
public class TaskTypeDAOImpl implements TaskTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

//    @Override
    public void create(TaskType taskType) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(taskType);
    }

//    @Override
    public TaskType getById(int id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (TaskType) session.get(TaskType.class, id);
    }

//    @Override
    public void delete(int id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        TaskType taskType = (TaskType) session.get(TaskType.class, id);
        if (taskType != null)
            session.delete(taskType);
    }

//    @Override
    public void update(TaskType taskType) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(taskType);
    }

//    @Override
    public List<TaskType> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(TaskType.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .addOrder(Order.asc("TaskTypeId")).list();
    }

    public List<TaskType> getAllTaskTypeByUserId(long userId) throws DBException {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(TaskType.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .addOrder(Order.asc("TaskTypeId")).list();
    }

}
