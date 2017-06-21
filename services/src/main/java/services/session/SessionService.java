package services.session;

import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SessionRepository;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
@Service
public class SessionService implements ISessionService {

    @Autowired
    private SessionRepository sessionRepository;


    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
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
