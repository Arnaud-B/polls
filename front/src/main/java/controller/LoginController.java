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

    @RequestMapping(path = "/login/",method = RequestMethod.GET)
    public ModelAndView loginView(){
        ModelAndView model = new ModelAndView("login/index");
        return model;
    }

    @RequestMapping(path = "/login/action/",method = RequestMethod.POST)
    public ModelAndView loginActionView(@RequestParam String username){
        User user = userService.findByUsername(username);
        Boolean user_exist = false;
        if(user != null) {
            System.out.println("user exist");
            user_exist = true;
            // redirect to sign in
        }
        else {
            System.out.println("user not exist");
            //redirect to sign up
        }
        ModelAndView model = new ModelAndView("login/action");
        model.addObject("user_exist", user_exist);
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(path = "/login/action/success/",method = RequestMethod.POST)
    public ModelAndView loginActionSuccessView(@RequestParam String username, @RequestParam String password, @RequestParam String age){
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        User user = userService.findByUsername(username);
        Boolean user_exist = false;
        if(user != null) {
            System.out.println("user exist");
            if(user.getPassword() == password) {
                System.out.println("connect");
            }
            else {
                System.out.println("not connect");
            }
        }
        else {
            int int_age = Integer.parseInt(age);
            User member = new User(username, password, int_age);
            User new_user = userService.save(member);
            System.out.println("user not exist");

        }
        ModelAndView model = new ModelAndView("login/action_success");
        return model;
    }
}
