package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
public class CreatePollController {

    @RequestMapping(path = "/create/poll",method = RequestMethod.GET)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("create_poll");
        return model;
    }
}
