package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nono on 23/05/2017.
 */
@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String label;

    @ManyToMany(mappedBy = "responses")
    private Set<User> users;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
