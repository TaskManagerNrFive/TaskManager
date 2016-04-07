package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Team;

import java.util.List;

/**
 * Created by NightStranger on 4/5/2016.
 */
public interface TeamDAO {

    void create(Team team) throws DBException;

    Team getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Team team) throws DBException;

    List<Team> getAll() throws DBException;
    
}
