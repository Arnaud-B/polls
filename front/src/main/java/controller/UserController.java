package controller;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.UserRepository;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/user/create/",method = RequestMethod.GET)
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("user/create");
        return model;
    }

    @RequestMapping(path = "/user/create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String username, @RequestParam String age, @RequestParam String password){
        int int_age = Integer.parseInt(age);
        User user = new User(username, password, int_age, User.ROLE_READER);
        User u = userRepository.save(user);
        ModelAndView model = new ModelAndView("user/create_success");
        return model;
    }

    @RequestMapping(path = "/user/list/",method = RequestMethod.GET)
    public ModelAndView listView(){
        ModelAndView model = new ModelAndView("user/list");
        return model;
    }
}
