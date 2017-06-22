package controller;

import entities.Response;
import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@Secured({"ROLE_ADMIN","ROLE_READER", "ROLE_USER"})
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseService responseService;

    @Secured({"ROLE_ADMIN","ROLE_READER"})
    @RequestMapping(path = "/session/create/",method = RequestMethod.GET)
    public ModelAndView sessionCreateView(){
        ModelAndView model = new ModelAndView("session/create");
        return model;
    }

    @Secured({"ROLE_ADMIN","ROLE_READER"})
    @RequestMapping(path = "/session/create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String question, @RequestParam String name, @RequestParam String[] answer){
        Session session = new Session();
        session.setQuestion(question);
        session.setName(name);
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

    @Secured({"ROLE_ADMIN","ROLE_READER"})
    @RequestMapping(path = "/session/answer/success/",method = RequestMethod.POST)
    public ModelAndView answerSuccessView(@RequestParam String[] responses_id){
        for (String response : responses_id)
        {
            System.out.println(response);
        }
        ModelAndView model = new ModelAndView("session/answer_success");
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

        int id = Integer.parseInt(str_id);
        Session session = sessionService.findById(id);

        List<Response> responses = responseService.findBySession_Id(id);

        ModelAndView model = new ModelAndView("session/detail");
        model.addObject("session", session);
        model.addObject("responses", responses);
        return model;
    }

}
