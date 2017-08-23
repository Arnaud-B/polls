package services.user;

import entities.Role;
import entities.User;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface IUserService {

    List<User> findAll();

    List<User> findByRolesIn(List<Role> roles);

    User findOne(Integer id);

    User findByUsername(String username);

    boolean exists(Integer id);

    User save(User user);

    boolean addUser(User user);

    void delete(Integer id);
}
