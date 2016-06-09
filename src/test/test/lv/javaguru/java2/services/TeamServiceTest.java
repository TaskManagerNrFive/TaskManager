package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * Created by NightStranger on 6/9/2016.
 */

@RunWith(MockitoJUnitRunner.class)

public class TeamServiceTest {

    @Mock
    private TeamDAO teamDAO;

    @InjectMocks
    private TeamService teamService = new TeamService();

    @Test
    public void validateIfEmptyName() {
        Team team = new Team();
        team.setName("");
        assertNotEquals("", teamService.validate(team));
        team.setName(null);
        assertNotEquals("", teamService.validate(team));
    }

    @Test
    public void validateIfNameIsNotEmpty() {
        Team team = new Team();
        team.setName("GREAT TEAM");
        assertEquals("", teamService.validate(team));
    }

    @Test
    public void createWhenExistedName() throws Exception {
        Team team = new Team();
        team.setName("GREAT TEAM");
        doReturn(new Team()).
                when(teamDAO).
                getByName(eq(team.getName()), eq(0L));
        try {
            teamService.create(team);
            fail("Must be exception!");
        }
        catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("Team with this name exist!", e.getMessage());
        }

    }

    @Test
    public void createWhenNotExistedName() throws Exception {
        Team team = new Team();
        team.setName("GREAT TEAM");
        doReturn(null).
                when(teamDAO).
                getByName(eq(team.getName()), eq(0L));
        doNothing().
                when(teamDAO).
                create(eq(team));
        try {
            teamService.create(team);
        }
        catch (Exception e) {
            fail("There must not be an exception!");
        }

    }

}