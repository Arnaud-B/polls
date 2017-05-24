package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(path = "/stats/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView statsViewGetById(@PathVariable int id){
        ModelAndView model = new ModelAndView("histo");
        model.addObject(id);
        return model;
    }

    @RequestMapping(path = "/stats?id={id}",method = RequestMethod.GET)
    @ResponseBody
    public String statsRedirect(@PathVariable int id){
        return "redirect:/stats/"+id;
    }
}
