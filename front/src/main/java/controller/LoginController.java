package controller;


import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.user.UserService;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public ModelAndView loginView(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(path = "/login/action",method = RequestMethod.POST)
    public ModelAndView loginActionView(@RequestParam String username){
        User user = userService.findByUsername(username);
        if(user != null) {
            // redirect to sign in
        }
        else {
            //redirect to sign up
        }
        ModelAndView model = new ModelAndView("login_action");
        return model;
    }
}
