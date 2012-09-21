package org.realty;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletFilter implements Filter {

    private FilterConfig config = null;

    public void destroy() {
        config = null;

    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        UsrInfo user = (UsrInfo) session.getAttribute("userInfo");
        if (user == null)
            user = new UsrInfo();
        Roles currentUser = null;
        List<Roles> roles = null;
        String command = null;

        if (user.IsLogin()) {
            currentUser = Roles.LOGGED;
            if (user.IsAdmin())
                currentUser = Roles.ADMIN;
        } else
            currentUser = Roles.ANONYMOUS;


        if (httpRequest.getQueryString() != null) {
            command = request.getParameter("command");
            roles = CommandFactory.getRolesByCommand(command);
        } else {
            command = httpRequest.getRequestURI().replace(httpRequest.getContextPath() + "/", "");
            roles = CommandFactory.getRolesByResourcePath(command);
        }


        //  List<Roles> roles = CommandFactory.getRoles(httpRequest.getRequestURI()+"?"+httpRequest.getQueryString());

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if ((roles.contains(currentUser))) {
            chain.doFilter(request, response);
        } else {
            if (currentUser == Roles.LOGGED) {
                ApplicationContext context = new ClassPathXmlApplicationContext("/springDI.xml");
                BeanFactory factory = context;
                CommandFactory test = (CommandFactory)factory.getBean("commandF");

                Command c = test.getCommand("userPage");
                String path = null;
                try {
                    path = c.execute(httpRequest, httpResponse);
                } catch (ParseException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                request.getRequestDispatcher(path).forward(request, response);

               // httpResponse.sendRedirect("UserPage.jsp");
            } else
                httpResponse.sendRedirect("Authentication.jsp");
        }
    }
}