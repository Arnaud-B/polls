package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
public class UserController {

    @RequestMapping(path = "/user/create/",method = RequestMethod.GET)
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("user/create");
        return model;
    }

    @RequestMapping(path = "/user/list/",method = RequestMethod.GET)
    public ModelAndView listView(){
        ModelAndView model = new ModelAndView("user/list");
        return model;
    }
}
