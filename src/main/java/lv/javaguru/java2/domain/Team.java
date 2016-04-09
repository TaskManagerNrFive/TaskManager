package lv.javaguru.java2.domain;

/**
 * Created by NightStranger on 4/5/2016.
 */

public class Team {

    private long teamID;
    private String name;
    private String description;

    public long getTeamID() {
        return teamID;
    }

    public void setTeamID(long teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
