package controller;


import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

    @Autowired
    private ModelData modelData;

    private Boolean wrong_password;

    @RequestMapping(path = "/login/",method = RequestMethod.GET)
    public ModelAndView loginView(){
        ModelAndView model = new ModelAndView("login/index");
        return model;
    }

    @RequestMapping(path = "/login/action/",method = RequestMethod.POST)
    public ModelAndView loginActionView(@RequestParam String username){
        User user = userService.findByUsername(username);
        Boolean user_exist = false;
        if(user != null)
        {
            user_exist = true;
        }
        ModelAndView model = new ModelAndView("login/action");
        model.addObject("user_exist", user_exist);
        model.addObject("wrong_password", this.wrong_password);
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(path = "/login/action/success/", method = RequestMethod.POST)
    public ModelAndView loginActionSuccessView(@RequestParam String username, @RequestParam String password, @RequestParam String age){
        User user = userService.findByUsername(username);
        Boolean user_exist = false;
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        if(user != null) {
            user_exist = true;
            if(BCrypt.checkpw(password, user.getPassword())) {
                this.wrong_password = false;
                modelData.setUser(user);
                return new ModelAndView("redirect:" + "/");
            }
            else {
                this.wrong_password = true;
                return this.loginActionView(user.getUsername());
            }
        }
        else {
            this.wrong_password = false;
            int int_age = Integer.parseInt(age);
            user = new User(username, pw_hash, int_age);
            User new_user = userService.save(user);
            modelData.setUser(user);
            return new ModelAndView("redirect:" + "/");
        }
    }

    @RequestMapping(path = "/logout/", method = RequestMethod.GET)
    public ModelAndView logoutView(){
        modelData.setUser(null);
        return this.loginView();
    }
}
