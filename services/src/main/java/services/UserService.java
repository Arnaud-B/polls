package services;

import java.util.List;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(int id) {
        return userRepository.findOne(id);
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
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
        User user_db = userRepository.save(user);
        return user_db;
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
    public void deleteUserById(int pid) {
        userRepository.deleteUserById(pid);
    }

}