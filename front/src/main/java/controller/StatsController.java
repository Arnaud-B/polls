package controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Corentin on 24/05/2017.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_READER"})
public class StatsController {

    @RequestMapping(path = "/stats",method = RequestMethod.GET)
    public ModelAndView statsViewGet(@RequestParam(value="id", required = false) String id){
        ModelAndView model = new ModelAndView("stats");
        if(id != null){
            model = new ModelAndView("histo");
            model.addObject(id);
        }
        return model;
    }

    @RequestMapping(path = "/stats/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView statsViewGetById(@PathVariable int id){
        ModelAndView model = new ModelAndView("histo");
        model.addObject(id);
        return model;
    }

/*
    @RequestMapping(path = "/stats",method = RequestMethod.GET)
    public String statsRedirect(@RequestParam int id){
        return "redirect:/stats/"+id;
    }
   */
}
