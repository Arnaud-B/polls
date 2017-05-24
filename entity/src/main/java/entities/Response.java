package entitiess;

import javax.persistence.*;

/**
 * Created by nono on 23/05/2017.
 */
@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String label;

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
}
