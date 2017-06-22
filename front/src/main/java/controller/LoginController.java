package controller;


import entities.User;
import filter.ModelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import services.role.RoleService;
import services.user.UserService;

import java.util.Arrays;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelData modelData;

    @RequestMapping(path = "",method = RequestMethod.GET)
    public ModelAndView loginView(){
        ModelAndView model = new ModelAndView("login/index");
        return model;
    }

    @RequestMapping(path = "action",method = RequestMethod.GET)
    public ModelAndView loginActionView(@RequestParam String username){
        User user = userService.findByUsername(username);
        ModelAndView model = null;
        if(user != null) {
            if(!user.getRoles().get(0).getAuthority().equals("ROLE_USER")){
                model = new ModelAndView("input_password");
            } else {
                model = new ModelAndView("input_continue");
                model.addObject("username", username);
            }
        } else {
            model = new ModelAndView("input_age");
            User  newUser = new User(username, BCrypt.hashpw("default",BCrypt.gensalt()));
            newUser.setRoles(Arrays.asList(roleService.findById(User.ROLE_USER)));
            userService.save(newUser);
        }
        return model;
    }

    @RequestMapping(path = "change", method = RequestMethod.GET)
    @ResponseBody
    public void loginChangeAge(@RequestParam String username, @RequestParam String age){
        User user = userService.findByUsername(username);
        if(user != null){
            user.setAge(Integer.parseInt(age));
            userService.save(user);
        }
    }


    @RequestMapping(path = "action/success/",method = RequestMethod.GET)
    public ModelAndView loginActionSuccessGetView(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() != null && auth.getPrincipal() instanceof User) {
            User user = (User)auth.getPrincipal();
            modelData.setUser(user);
        }
        ModelAndView model = new ModelAndView("login/action_success");
        return model;
    }

    @RequestMapping(path = "/logout/", method = RequestMethod.GET)
    public ModelAndView logoutView(){
        modelData.setUser(null);
        return this.loginView();
    }
}
