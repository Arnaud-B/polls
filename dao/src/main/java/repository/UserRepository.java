package repository;

import entities.Role;
import entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    List<User> findByRolesIn(List<Role> roles);

    User findOne(Integer id);

    User findByUsername(String username);

    boolean exists(Integer id);

    User save(User user);

    void delete(Integer id);

}
