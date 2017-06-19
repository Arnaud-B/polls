package repository;

import entities.Response;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nono on 25/05/2017.
 */
public interface ResponseRepository extends CrudRepository<Response, Integer> {

    Response findById(Integer id);
    List<Response> findAll();
    List<Response> findBySession_Id(Integer id);
    boolean exists(Integer id);
    Response save(Response response);
    void deleteResponseById(int id);

}
