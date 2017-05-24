package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Corentin on 24/05/2017.
 */
@Controller
public class StatsController {

    @RequestMapping(path = "/stats",method = RequestMethod.GET)
    public ModelAndView statsViewGet(){
        ModelAndView model = new ModelAndView("stats");
        return model;
    }

}
