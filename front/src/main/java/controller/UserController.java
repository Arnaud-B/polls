package controller;

import entities.Role;
import entities.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.role.RoleService;
import services.user.UserService;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
@RequestMapping(path = "/user/")
@Secured({"ROLE_ADMIN"})
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "roleService")
    private RoleService roleService;

    @RequestMapping(path = "create/",method = RequestMethod.GET)
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("user/create");
        return model;
    }

    @RequestMapping(path = "create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String username, @RequestParam String age, @RequestParam String password){
        int int_age = Integer.parseInt(age);
        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), int_age);
        user.setRoles(Arrays.asList(roleService.findByName("ROLE_REDACTOR")));
        User u = userService.save(user);
        ModelAndView model = new ModelAndView("user/create_success");
        return model;
    }

    @RequestMapping(path = "list/",method = RequestMethod.GET)
    public ModelAndView listView(){
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleService.findByName("ROLE_REDACTOR"));
        List<User> users = userService.findByRolesIn(roles);
        ModelAndView model = new ModelAndView("user/list");
        model.addObject("users", users);
        return model;
    }
}
