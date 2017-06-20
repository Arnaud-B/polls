package filter;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by nono on 20/06/2017.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    public ModelData modelData;

    @ModelAttribute
    public void getCurrentUser(Model model) {
        User user = modelData.getUser();
        model.addAttribute("current_user", user);
        model.addAttribute("role_user", User.ROLE_USER);
        model.addAttribute("role_admin", User.ROLE_ADMIN);
        model.addAttribute("role_reader", User.ROLE_READER);
    }
}