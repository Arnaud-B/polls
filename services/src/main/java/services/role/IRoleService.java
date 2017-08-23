package services.role;

import entities.Role;
import java.util.List;

/**
 * Created by Corentin on 20/06/2017.
 */
public interface IRoleService {

    List<Role> findAll();

    Role findOne(Integer id);

    Role findByName(String name);

    boolean exists(Integer id);

    Role save(Role role);

    void delete(Integer id);

}

