package controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_REDACTOR", "ROLE_USER"})
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView indexViewGet(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ModelAndView indexViewPost(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ModelAndView indexUserGet(){
        ModelAndView model = new ModelAndView("user");
        return model;
    }
}
