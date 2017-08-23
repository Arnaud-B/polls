package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nico on 09/02/2016.
 */
@WebServlet(value = "/servlet/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("Hello from WelcomeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
