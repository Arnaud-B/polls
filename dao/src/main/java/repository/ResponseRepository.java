package repository;

import entities.Response;
import entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public interface ResponseRepository extends CrudRepository<Response, Integer> {

    List<Response> findAll();

    Response findOne(Integer id);

    List<Response> findBySession_Id(int id);

    List<Response> findByUsersIn(List<User> users);

    boolean exists(Integer id);

    Response save(Response response);

    void delete(Integer id);

}
