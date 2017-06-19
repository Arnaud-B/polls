package controller;

import entities.Response;
import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.response.ResponseService;
import services.session.SessionService;

import java.util.List;

/**
 * Created by nono on 19/06/2017.
 */
@Controller
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseService responseService;

    @RequestMapping(path = "/session/create/",method = RequestMethod.GET)
    public ModelAndView sessionCreateView(){
        ModelAndView model = new ModelAndView("session/create");
        return model;
    }

    @RequestMapping(path = "/session/create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String question, @RequestParam String[] answer){
        Session session = new Session();
        session.setQuestion(question);
        Session s = sessionService.save(session);
        for(int i = 0; i < answer.length; i++)
        {
            if(answer[i] != "") {
                Response response = new Response(s, answer[i]);
                Response r = responseService.save(response);
            }
        }
        ModelAndView model = new ModelAndView("session/create_success");
        return model;
    }

    @RequestMapping(path = "/session/list/",method = RequestMethod.GET)
    public ModelAndView listView(){
        List<Session> sessionList = sessionService.findAll();
        ModelAndView model = new ModelAndView("session/list");
        model.addObject("sessions", sessionList);
        return model;
    }

    @RequestMapping(path = "/session/{id}/",method = RequestMethod.GET)
    public ModelAndView detailView(@PathVariable(value="id") String str_id){
        System.out.println(str_id);
        int id = Integer.parseInt(str_id);
        Session session = sessionService.findById(id);
        ModelAndView model = new ModelAndView("session/detail");
        model.addObject("session", session);
        return model;
    }

}
