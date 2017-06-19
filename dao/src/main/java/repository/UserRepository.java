package repository;

import entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    List<User> findAll();
    boolean exists(Integer id);
    User save(User user);
    void deleteUserById(int id);

}
