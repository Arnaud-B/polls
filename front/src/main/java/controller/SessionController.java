package controller;

import entities.Response;
import entities.Session;
import entities.User;
import filter.ModelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@Secured({"ROLE_ADMIN","ROLE_READER", "ROLE_USER"})
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelData modelData;

    private Boolean already_answered;


    @Secured({"ROLE_ADMIN","ROLE_READER"})
    @RequestMapping(path = "create/",method = RequestMethod.GET)
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

    @Secured({"ROLE_ADMIN","ROLE_READER"})
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

    @Secured({"ROLE_ADMIN","ROLE_READER"})
    @RequestMapping(path = "answer/success/",method = RequestMethod.POST)
    public ModelAndView answerSuccessView(@RequestParam String[] responses_id, @RequestParam String session_id){
        User user = modelData.getUser();
        List<User> users = new ArrayList<User>();
        users.add(user);
        List<Response> user_responses = responseService.findByUsers(users);
        this.already_answered = false;
        // Check if the current user has already answered this session
        if(user_responses.size() > 0) {
            for (Response user_response : user_responses) {
                if (user_response.getSession().getId() == Integer.parseInt(session_id)) {
                    this.already_answered = true;
                    break;
                }
            }
        }
        if (user != null && !this.already_answered) {
            for (String response_id : responses_id)
            {
                Response response = responseService.findById(Integer.parseInt(response_id));
                user_responses.add(response);
            }
            user.setResponses(user_responses);
            userService.save(user);
        }
        ModelAndView model = new ModelAndView("session/answer_success");
        model.addObject("already_answered", this.already_answered);
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
