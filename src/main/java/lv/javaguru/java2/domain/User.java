package lv.javaguru.java2.domain;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(name="UserID", columnDefinition = "int")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "TeamID")
    private Long teamId;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null) return false;
        if (!(object instanceof User)) return false;
        if (((User) object).getUserId()==this.userId) return true;
        else return false;
    }

    //    @OneToMany(fetch = Lazy)
    //    private List<TaskType> taskTypes;
    public String getFullName() {
        String fullName;
        String space = " ";
        firstName = getFirstName();
        lastName = getLastName();
        fullName  = firstName + space + lastName;
        return fullName;
    }
}