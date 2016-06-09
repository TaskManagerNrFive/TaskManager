package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.DatabaseDataCleaner;
import lv.javaguru.java2.servlet.mvc.SpringAppConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * Created by NightStranger on 6/8/2016.
 */

@Component
public class DatabaseDataCleanerImpl implements DatabaseDataCleaner {

    @Autowired
    private SessionFactory sessionFactory;

    public void cleanDatabase() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        for(String tableName : getTableNames()) {
            Query deleteQuery = session.createSQLQuery("delete from " + tableName);
            int updated = deleteQuery.executeUpdate();
        }
    }

}
