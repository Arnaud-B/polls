package services.user;

import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRolesIn(List<Role> roles) {
        return userRepository.findByRolesIn(roles);
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean exists(Integer id) {
        boolean result = false;
        if(userRepository.exists(id)) {
            result = true;
        }
        return result;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public synchronized boolean addUser(User user){
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public void delete(Integer pid) {
        userRepository.delete(pid);
    }

}