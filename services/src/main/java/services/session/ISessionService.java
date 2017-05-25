package services.session;

import entities.Session;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public interface ISessionService {

    Session findById(Integer id);
    List<Session> findAll();
    boolean exists(Integer id);
    Session save(Session session);
    void deleteSessionById(Integer id);

}
