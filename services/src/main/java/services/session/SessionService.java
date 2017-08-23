package services.session;

import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SessionRepository;
import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
@Service("sessionService")
public class SessionService implements ISessionService {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public List<Session> findAllByResponseUserIsNull() {
        return sessionRepository.findDistinctByResponses_UsersIsNull();
    }

    @Override
    public Session findOne(Integer id) {
        return sessionRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        boolean result = false;
        if(sessionRepository.exists(id)) {
            result = true;
        }
        return result;
    }

    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void delete(Integer id) {
        sessionRepository.delete(id);
    }
}
