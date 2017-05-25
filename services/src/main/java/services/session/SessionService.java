package services.session;

import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import repository.SessionRepository;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public class SessionService implements ISessionService {

    @Autowired
    private SessionRepository sessionRepository;


    @Override
    public Session save(Session session) {
        Session user_db = sessionRepository.save(session);
        return user_db;
    }


    @Override
    public void deleteSessionById(Integer id) {
        sessionRepository.deleteSessionById(id);
    }

    @Override
    public Session findById(Integer id) {
        return sessionRepository.findOne(id);
    }

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public boolean exists(Integer id) {
        boolean result = false;
        if(sessionRepository.exists(id)) {
            result = true;
        }
        return result;
    }



}
