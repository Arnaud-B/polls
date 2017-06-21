package controller;

import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.session.SessionService;

import java.util.List;

/**
 * Created by Corentin on 24/05/2017.
 */
@Controller
@RequestMapping(path = "/stats/")
public class StatsController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(path = "",method = RequestMethod.GET)
    public ModelAndView statsViewGet(){
        List<Session> sessionList = sessionService.findAll();
        for(Session session : sessionList) {
            if(session.getResponses() != null) {
                sessionList.remove(session);
            }
        }
        ModelAndView model = new ModelAndView("stats");
        model.addObject("sessions", sessionList);
        return model;
    }

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView statsViewGetById(@PathVariable int id){
        ModelAndView model = new ModelAndView("histo");
        model.addObject(id);
        return model;
    }

    @RequestMapping(path = "?id={id}",method = RequestMethod.GET)
    @ResponseBody
    public String statsRedirect(@PathVariable int id){
        return "redirect:/stats/"+id;
    }
}
