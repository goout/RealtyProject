package org.realty;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RealtyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		service(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		service(request, response);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String command = request.getParameter("command");

        ApplicationContext context = new ClassPathXmlApplicationContext("/hibernate.xml");
        BeanFactory factory = context;
        CommandFactory test = (CommandFactory)factory.getBean("commandF");

		Command c = test.getCommand(command);
        String path = null;
        try {
            path = c.execute(request, response);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        request.getRequestDispatcher(path).forward(request, response);

	}

}
