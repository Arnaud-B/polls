package controller;

import entities.Response;
import entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.response.ResponseService;
import services.session.SessionService;

/**
 * Created by Corentin on 23/05/2017.
 */
@Controller
public class CreatePollController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseService responseService;

    @RequestMapping(path = "/create/poll",method = RequestMethod.GET)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("create_poll");
        return model;
    }

    @RequestMapping(path = "/create/poll/success",method = RequestMethod.POST)
    public ModelAndView createPollSuccessView(@RequestParam String question, @RequestParam String[] answer){
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
        ModelAndView model = new ModelAndView("create_poll_success");
        return model;
    }
}
