package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by NightStranger on 4/5/2016.
 */

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamID", nullable = false)
    private long teamID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT")
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
