package repository;

import entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Corentin on 20/06/2017.
 */
public interface RoleRepository  extends CrudRepository<Role, Integer> {

    List<Role> findAll();

    Role findOne(Integer id);

    Role findByName(String name);

    boolean exists(Integer id);

    Role save(Role role);

    void delete(Integer id);

}