package services;

import entities.User;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface IUserService {

    User findByUsername(String username);
    User findById(int id);
    List<User> findAll();
    boolean exists(Integer id);
    User save(User user);
    boolean addUser(User user);
    void deleteUserById(int id);
}
