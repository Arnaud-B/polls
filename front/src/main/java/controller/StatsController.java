package controller;

import entities.Response;
import entities.Session;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.response.ResponseService;
import services.session.SessionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corentin on 24/05/2017.
 */
@Controller
@RequestMapping(path = "/stats/")
public class StatsController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ResponseService responseService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView statsViewGet(){
        List<Session> sessionList = sessionService.findAllByResponseUserIsNull();
        List<Session> sessions_no_answer = new ArrayList<Session>();
        for (Session session : sessionList) {
            Boolean user_response_exists = false;
            for (Response response : session.getResponses()) {
                if (response.getUsers().size() > 0) {
                    user_response_exists = true;
                }
            }
            if (!user_response_exists) {
                sessions_no_answer.add(session);
            }
        }
        ModelAndView model = new ModelAndView("stats");
        model.addObject("sessions_no_answer", sessions_no_answer);
        model.addObject("sessions", sessionService.findAll());
        return model;
    }

    @RequestMapping(path = "form/", method = RequestMethod.POST)
    public ModelAndView statsViewForm(@RequestParam String id) {
        return new ModelAndView("redirect:" + "/stats/"+id+"/");
    }

    @RequestMapping(path = "{id}/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView statsViewGetById(@PathVariable int id){
        ModelAndView model = new ModelAndView("histo");
        List<Response> responses = responseService.findBySession_Id(id);
        model.addObject("responses", responses);

        /*************** DATA for Js histo ***************************/
        // Convert List<T> in json array
        String[] resps = new String[responses.size()];
        for (int i = 0; i<responses.size(); i++) {
            resps[i] = responses.get(i).getLabel();
        }
        model.addObject("responses_json", toJavascriptArray(resps));

        // age group :
        // ["-10", "10-15", "15-20", "20-25", "25-30", "30-35", "35-40", "40-45", "45-50", "50-55", "55-60", "60-65", "65-70", "70-75", "75-80", "80-85", "+85"]
        int[] age_group = new int[17];
        for(int j=0; j<age_group.length; j++) {
            age_group[j] = 0;
        }
        int[][] age_group_per_response = new int[responses.size()][17];
        for (Response r : responses) {
            int index = responses.indexOf(r);
            // answer exist
            if(r.getUsers().size() > 0) {
                for(User user : r.getUsers()) {
                    int index_age_group = (int) (((user.getAge() - 10) / 5 + 1) - 0.5f);
                    age_group[index_age_group] += 1;
                    age_group_per_response[index][index_age_group] += 1;
                }
            }
        }
        model.addObject("age_group", toIntJavascriptArray(age_group));
        model.addObject("age_group_per_response", to2IntJavascriptArray(age_group_per_response));
        /***************************************************************/
        return model;
    }

    public static String toJavascriptArray(String[] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<arr.length; i++){
            sb.append("\"").append(arr[i]).append("\"");
            if(i+1 < arr.length){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static String toIntJavascriptArray(int[] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<arr.length; i++){
            sb.append("\"").append(arr[i]).append("\"");
            if(i+1 < arr.length){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static String to2IntJavascriptArray(int[][] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<arr.length; i++){
            sb.append("[");
            for(int j=0; j<arr[i].length; j++){
                sb.append("\"").append(arr[i][j]).append("\"");
                if(j+1 < arr[i].length){
                    sb.append(",");
                }
            }
            sb.append("]");
            if(i+1 < arr.length){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
