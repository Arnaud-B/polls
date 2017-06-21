package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by nono on 23/05/2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String username;

    @Column
    private int age;

    @Column
    private int role;

    public static int ROLE_USER = 1;
    public static int ROLE_ADMIN = 2;
    public static int ROLE_READER = 3;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Session> sessions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_response",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "response_id", referencedColumnName = "id")
    )

    private List<Response> responses;

    public User() {
    }

    private String password;


    public User(int id) {
        this.id = id;
    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.role = ROLE_USER;
    }

    public User(String username, String password, int age, int role) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

}
