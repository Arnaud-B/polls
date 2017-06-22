package repository;

import entities.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface SessionRepository extends CrudRepository<Session, Integer> {

    List<Session> findAll();

    List<Session> findDistinctByResponses_UsersIsNull();

    Session findOne(Integer id);

    boolean exists(Integer id);

    Session save(Session session);

    void delete(Integer id);

}
