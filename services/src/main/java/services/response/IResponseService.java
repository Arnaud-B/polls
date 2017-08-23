package services.response;

import entities.Response;
import entities.User;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public interface IResponseService {

    List<Response> findAll();

    Response findOne(Integer id);

    List<Response> findBySessionId(Integer id);

    List<Response> findByUsers(List<User> users);

    boolean exists(Integer id);

    Response save(Response response);

    void delete(Integer id);

}
