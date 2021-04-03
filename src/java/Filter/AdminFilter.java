package Filter;

import Entities.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/faces/login.xhtml";
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);
         if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(request, response);
        } else {
            //request.getRequestDispatcher("/LoginServlet").forward(request,response);  
            res.sendRedirect(loginURI);
        }
       // String url = req.getRequestURI();
        //Employee e = (Employee) req.getSession().getAttribute("user");
        /*if (e == null) {
            if (url.contains("logout")) {
                res.sendRedirect(req.getContextPath() + "/login");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("login")) {
                res.sendRedirect(req.getContextPath() + "/adminprofile");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/index");
            } else {
                chain.doFilter(request, response);
            }
        } */
        /*HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String url = req.getRequestURI();
        String loginURI = req.getContextPath() + "/faces/login.xhtml";
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);
        PrintWriter out=resp.getWriter();  
        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(request, response);
        } else if (!loggedIn) {
            //request.getRequestDispatcher("/LoginServlet").forward(request,response);  
            resp.sendRedirect(loginURI);
            if(url.contains("logout")) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/index");
        }
        } else if (url.contains("index")) {
            resp.sendRedirect(req.getContextPath() + "/index");
            chain.doFilter(request, response);
        }/* else if (url.contains("logout")) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/index");
        }*/
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

}
