package controller;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import services.IHelloService;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class IndexController {

    ModelData modelData;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView indexViewGet(){
        ModelAndView model = new ModelAndView("index");
        /*User user = modelData.getUser();
        model.addObject("current_user", user);*/
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
