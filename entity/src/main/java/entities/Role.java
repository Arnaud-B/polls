package entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Corentin on 20/06/2017.
 */
@Entity
@Table(name = "role")
public class Role  implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
