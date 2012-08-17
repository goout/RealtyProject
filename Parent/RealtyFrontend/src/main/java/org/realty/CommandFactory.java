package org.realty;

import java.util.*;

public class CommandFactory {
	@SuppressWarnings("serial")
	private static Map<String, Command> commands = new HashMap<String, Command>() {
		{
			put("addUser", new AddUserCommand());
			put("allUser", new AllUserCommand());
			put("delUser", new DelUserCommand());
			put("addAdvert", new AddAdvertCommand());
			put("allAdvert", new AllAdvertCommand());
			put("delAdvert", new DelAdvertCommand());
			put("addComment", new AddCommentCommand());
			put("allComment", new AllCommentCommand());
			put("delComment", new DelCommentCommand());
			put("signIn", new AuthenticationCommand());
			put("indexGuest", new IndexGuestCommand());
			put("LogOut", new LogOutCommand());
		}
	};

    private static Map<String, List<Roles>> role = new HashMap<String, List<Roles>>() {
        {
            put("/RealtyServlet?command=addUser", Arrays.asList(Roles.ANONYMOUS, Roles.ADMIN));
            put("/RealtyServlet?command=allUser",  Arrays.asList(Roles.ADMIN));
            put("/RealtyServlet?command=delUser",  Arrays.asList(Roles.ADMIN));
            put("/RealtyServlet?command=addAdvert",  Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("/RealtyServlet?command=allAdvert",  Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("/RealtyServlet?command=delAdvert", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("/RealtyServlet?command=addComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("/RealtyServlet?command=allComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
            put("/RealtyServlet?command=delComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("/RealtyServlet?command=signIn", Arrays.asList(Roles.ANONYMOUS));
            put("/RealtyServlet?command=indexGuest", Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
            put("/RealtyServlet?command=LogOut", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("/RealtyFrontend/Authentication.jsp", Arrays.asList(Roles.ANONYMOUS));
        }
    };

	public static Command getCommand(String commandName) {

		Command command = commands.get(commandName);
		return command != null ? command : new IndexGuestCommand();
	}

	public static List<Roles> getRoles(String commandName) {
        List<Roles> roles = role.get(commandName);
        return roles != null ? roles : new ArrayList<Roles>();
	}




	

}