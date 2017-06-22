package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Nico on 09/02/2016.
 */
@WebFilter(value = "/servlet/*")
public class ServletFilter implements javax.servlet.Filter  {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init Servlet filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ServletFilter.doFilter before filterChain");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("ServletFilter.doFilter after filterChain");
    }

    @Override
    public void destroy() {
        System.out.println("ServletFilter.destroy");
    }
}
