package services.session;

import entities.Session;
import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public interface ISessionService {

    List<Session> findAll();

    List<Session> findAllByResponseUserIsNull();

    Session findOne(Integer id);

    boolean exists(Integer id);

    Session save(Session session);

    void delete(Integer id);

}
