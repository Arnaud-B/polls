package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import services.IHelloService;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class IndexController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("message","Hello world from indexController -> " + helloService.hello());
        System.out.println(model);
        return model;
    }

    /*@RequestMapping("/")
    public @ResponseBody String index(){
        System.out.println("index controller");
        return "index";
    }*/


}
