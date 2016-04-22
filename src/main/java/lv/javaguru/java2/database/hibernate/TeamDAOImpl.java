package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NightStranger on 4/5/2016.
 */

@Component("ORM_TeamDAO")
@Transactional
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Team team) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(team);
    }

    @Override
    public Team getById(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Team) session.get(Team.class, id);
    }

    @Override
    public List<Team> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Team.class).list();
    }

    @Override
    public void delete(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        Team team = (Team) session.get(Team.class, id);
        session.delete(team);
    }

    @Override
    public void update(Team team) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(team);
    }
    
}
