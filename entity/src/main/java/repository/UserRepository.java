package crud;

import entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nono on 24/05/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
