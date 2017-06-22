package services.role;

import entities.Role;

import java.util.List;

/**
 * Created by Corentin on 20/06/2017.
 */
public interface IRoleService {

    Role findById(Integer id);
    List<Role> findAll();
    boolean exists(Integer id);
    Role save(Role role);
    void deleteRoleById(Integer id);
}

