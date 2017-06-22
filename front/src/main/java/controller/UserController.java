package controller;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.Arrays;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
@RequestMapping(path = "/user/")
@Secured({"ROLE_ADMIN"})
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(path = "create/",method = RequestMethod.GET)
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("user/create");
        return model;
    }

    @RequestMapping(path = "create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String username, @RequestParam String age, @RequestParam String password){
        int int_age = Integer.parseInt(age);
        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), int_age);
        user.setRoles(Arrays.asList(roleRepository.findRoleByRoleId(User.ROLE_READER)));
        User u = userRepository.save(user);
        ModelAndView model = new ModelAndView("user/create_success");
        return model;
    }

    @RequestMapping(path = "list/",method = RequestMethod.GET)
    public ModelAndView listView(){
        ModelAndView model = new ModelAndView("user/list");
        return model;
    }
}
