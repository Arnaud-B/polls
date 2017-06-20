package controller;

import entities.Response;
import entities.Session;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.response.ResponseService;
import services.session.SessionService;
import services.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nono on 19/06/2017.
 */
@Controller
@RequestMapping(path = "/session/")
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private UserService userService;

    @Autowired
    private ModelData modelData;

    @RequestMapping(path = "create/",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView sessionCreateView(){
        User user = modelData.getUser();
        Boolean disabled_button = true;
        if (user != null) {
           disabled_button = false;
        }
        ModelAndView model = new ModelAndView("session/create");
        model.addObject("disabled_button", disabled_button);
        return model;
    }


    @RequestMapping(path = "create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String question, @RequestParam String name, @RequestParam String[] answer){
        User user = modelData.getUser();
        if (user != null) {
            Session session = new Session();
            session.setQuestion(question);
            session.setName(name);
            session.setUser(user);
            Session s = sessionService.save(session);
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] != "") {
                    Response response = new Response(s, answer[i]);
                    Response r = responseService.save(response);
                }
            }
        }
        ModelAndView model = new ModelAndView("session/create_success");
        return model;
    }

    @RequestMapping(path = "answer/success/",method = RequestMethod.POST)
    public ModelAndView answerSuccessView(@RequestParam String[] responses_id){
        User user = modelData.getUser();
        List<Response> response_list = new ArrayList<Response>();
        if(user != null) {
            for (String response_id : responses_id)
            {
                Response response = responseService.findById(Integer.parseInt(response_id));
                response_list.add(response);
            }
            user.setResponses(response_list);
            userService.save(user);
        }
        ModelAndView model = new ModelAndView("session/answer_success");
        return model;
    }

    @RequestMapping(path = "list/",method = RequestMethod.GET)
    public ModelAndView listView(){
        List<Session> sessionList = sessionService.findAll();
        ModelAndView model = new ModelAndView("session/list");
        model.addObject("sessions", sessionList);
        return model;
    }

    @RequestMapping(path = "{id}/",method = RequestMethod.GET)
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
