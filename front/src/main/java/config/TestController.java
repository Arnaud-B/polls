package config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class TestController {

    @RequestMapping(produces = "application/json", method = RequestMethod.GET, path = "/welcome")
    public @ResponseBody String welcomeRest() {
        return "Welcome !";
    }

}
