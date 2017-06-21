package services.response;

import entities.Response;
import entities.User;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public interface IResponseService {

    Response findById(Integer id);
    List<Response> findAll();
    List<Response> findBySession_Id(Integer id);
    List<Response> findByUsers(List<User> users);
    boolean exists(Integer id);
    Response save(Response response);
    void deleteResponseById(Integer id);

}
