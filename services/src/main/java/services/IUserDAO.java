package services;

/**
 * Created by nono on 24/05/2017.
 */
public interface IUserDAO {
    List<Person> getAllPersons();
    Person getPersonById(int pid);
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int pid);
    boolean personExists(String name, String location);
}
