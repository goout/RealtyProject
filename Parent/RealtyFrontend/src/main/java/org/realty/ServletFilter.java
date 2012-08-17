package org.realty;

import java.io.IOException;

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


		if (User.IsLogin() == "false") {
			httpResponse.sendRedirect("Authentication.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}
}