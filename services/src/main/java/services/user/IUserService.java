package services.user;

import entities.Role;
import entities.User;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface IUserService {

    User findByUsername(String username);
    User findById(int id);
    List<User> findAll();
    List<User> findByRolesIn(List<Role> roles);
    boolean exists(Integer id);
    User save(User user);
    boolean addUser(User user);
    void deleteUserById(int id);
}
