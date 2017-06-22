package services.response;

import entities.Response;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ResponseRepository;
import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
@Service("responseService")
public class ResponseService implements IResponseService {

    private ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    @Override
    public Response findOne(Integer id) {
        return responseRepository.findOne(id);
    }

    @Override
    public List<Response> findBySessionId(Integer id) {
        return responseRepository.findBySession_Id(id);
    }

    @Override
    public List<Response> findByUsers(List<User> users) {
        return responseRepository.findByUsersIn(users);
    }

    @Override
    public boolean exists(Integer id) {
        boolean result = false;
        if(responseRepository.exists(id)) {
            result = true;
        }
        return result;
    }

    @Override
    public Response save(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public void delete(Integer id) {
        responseRepository.delete(id);
    }
}
