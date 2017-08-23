package controller;

import entities.Response;
import entities.Session;
import entities.User;
import filter.ModelData;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.response.ResponseService;
import services.session.SessionService;
import services.user.UserService;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nono on 19/06/2017.
 */
@Controller
@RequestMapping(path = "/session/")
@Secured({"ROLE_ADMIN", "ROLE_REDACTOR", "ROLE_USER"})
public class SessionController {

    @Resource(name = "sessionService")
    private SessionService sessionService;

    @Resource(name = "responseService")
    private ResponseService responseService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "modelData")
    private ModelData modelData;


    @Secured({"ROLE_ADMIN", "ROLE_REDACTOR"})
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

    @Secured({"ROLE_ADMIN", "ROLE_REDACTOR"})
    @RequestMapping(path = "create/success/",method = RequestMethod.POST)
    public ModelAndView createSuccessView(@RequestParam String name, @RequestParam String start_date, @RequestParam String end_date, @RequestParam String question, @RequestParam String[] answer) throws ParseException {
        User user = modelData.getUser();
        if (user != null) {
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            Session session = new Session();
            session.setUser(user);
            session.setName(name);
            session.setStartDate(new Date(formatDate.parse(start_date).getTime()));
            session.setEndDate(new Date(formatDate.parse(end_date).getTime()));
            session.setQuestion(question);
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

    @Secured({"ROLE_ADMIN", "ROLE_REDACTOR"})
    @RequestMapping(path = "answer/success/",method = RequestMethod.POST)
    public ModelAndView answerSuccessView(@RequestParam String[] responses_id, @RequestParam String session_id){
        User user = modelData.getUser();
        List<User> users = new ArrayList<User>();
        users.add(user);
        List<Response> user_responses = responseService.findByUsers(users);
        Boolean already_answered = false;
        // Check if the current user has already answered this session
        if(user_responses.size() > 0) {
            for (Response user_response : user_responses) {
                if (user_response.getSession().getId() == Integer.parseInt(session_id)) {
                    already_answered = true;
                    break;
                }
            }
        }
        if (user != null && !already_answered) {
            for (String response_id : responses_id)
            {
                Response response = responseService.findOne(Integer.parseInt(response_id));
                user_responses.add(response);
            }
            user.setResponses(user_responses);
            userService.save(user);
        }
        ModelAndView model = new ModelAndView("session/answer_success");
        model.addObject("already_answered", already_answered);
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
        Session session = sessionService.findOne(id);
        List<Response> responses = responseService.findBySessionId(id);
        ModelAndView model = new ModelAndView("session/detail");
        model.addObject("session", session);
        model.addObject("responses", responses);
        return model;
    }

}
