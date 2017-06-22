package entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by nono on 23/05/2017.
 */
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column
    private int age;
    @Column
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "id", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name="roleId", nullable = false, updatable = false)})
    private List<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Session> sessions;

    public static int ROLE_USER = 1;
    public static int ROLE_ADMIN = 2;
    public static int ROLE_READER = 3;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, int int_age) {
        this.username = username;
        this.age = int_age;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        //this.roles = Arrays.asList(new Role());
    }

    public User(String username, String password, int age, int role) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_response",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "response_id", referencedColumnName = "id")
    )
    private List<Response> responses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}