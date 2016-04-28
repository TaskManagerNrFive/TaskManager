package lv.javaguru.java2.domain;


import org.springframework.context.annotation.Lazy;

import javax.persistence.OneToMany;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class User implements Comparable{

    private long userId;
    private String firstName;
    private String lastName;
    private long teamID;
    private String email;
    private String password;

//    @OneToMany(fetch = Lazy)
//    private List<TaskType> taskTypes;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public long getTeamID() {
        return teamID;
    }

    public void setTeamID(long teamID) {
        this.teamID = teamID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //Не уверена, что это пригодится!
    public String toString() {
        return firstName + " " + lastName + "Team ID = " + teamID + "E-mail: " + email + "Password: " + password;
    }
    public int compareTo(Object obj) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}
