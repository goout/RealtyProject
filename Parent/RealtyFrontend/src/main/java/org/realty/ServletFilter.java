package org.realty;

import java.io.IOException;
import java.util.Arrays;
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
		List<Roles> currentUser = null;

        if(user.IsLogin()){
            currentUser = Arrays.asList(Roles.LOGGED);
           if(user.IsAdmin())
                currentUser = Arrays.asList(Roles.ADMIN);
        }    else
           currentUser = Arrays.asList(Roles.ANONYMOUS);



        List<Roles> roles = CommandFactory.getRoles(httpRequest.getRequestURI()+"?"+httpRequest.getQueryString());
        System.out.printf("  %s"+"?"+"%s  ",httpRequest.getRequestURI(),httpRequest.getQueryString());



        if ((roles.contains(currentUser))) {
            chain.doFilter(request, response);
		} else {
            httpResponse.sendRedirect("Authentication.jsp");
		}
	}
}