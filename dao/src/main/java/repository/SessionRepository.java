package repository;

import entities.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nono on 24/05/2017.
 */
public interface SessionRepository extends CrudRepository<Session, Integer> {

    Session findById(Integer id);
    List<Session> findAll();
    boolean exists(Integer id);
    Session save(Session session);
    void deleteSessionById(int id);

}
