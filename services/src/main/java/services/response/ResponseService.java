package services.response;

import entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ResponseRepository;


import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public class ResponseService implements IResponseService {

    @Autowired
    private ResponseRepository responseRepository;


    @Override
    public Response save(Response response) {
        Response response_db = responseRepository.save(response);
        return response_db;
    }


    @Override
    public void deleteResponseById(Integer id) {
        responseRepository.deleteResponseById(id);
    }

    @Override
    public Response findById(Integer id) {
        return responseRepository.findOne(id);
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    @Override
    public boolean exists(Integer id) {
        boolean result = false;
        if(responseRepository.exists(id)) {
            result = true;
        }
        return result;
    }
}
