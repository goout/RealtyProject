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

    private static Map<String, List<Roles>> roleByCommand = new HashMap<String, List<Roles>>() {
        {
            put("addUser", Arrays.asList(Roles.ANONYMOUS, Roles.ADMIN, Roles.LOGGED));
            put("allUser",  Arrays.asList(Roles.ADMIN,Roles.LOGGED));
            put("delUser",  Arrays.asList(Roles.ADMIN,Roles.LOGGED));
            put("addAdvert",  Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("allAdvert",  Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("delAdvert", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("addComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("allComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
            put("delComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("signIn", Arrays.asList(Roles.ANONYMOUS));
            put("indexGuest", Arrays.asList(Roles.ADMIN, Roles.ANONYMOUS));
            put("LogOut", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
        }
    };



    private static Map<String, List<Roles>> roleByResourcePath = new HashMap<String, List<Roles>>() {
        {
            put("User.jsp", Arrays.asList(Roles.ADMIN));
            put("index.jsp",   Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
            put("Advert.jsp",  Arrays.asList(Roles.LOGGED));
            put("Comment.jsp",  Arrays.asList(Roles.LOGGED));
            put("Authentication.jsp",  Arrays.asList(Roles.ANONYMOUS));
            put("RealtyServlet" , Arrays.asList(Roles.ADMIN, Roles.ANONYMOUS));
             }
    };


	public static Command getCommand(String commandName) {

		Command command = commands.get(commandName);
		return command != null ? command : new IndexGuestCommand();
	}

	public static List<Roles> getRolesByCommand(String commandName) {
        List<Roles> roles = roleByCommand.get(commandName);
        return roles != null ? roles : Arrays.asList(Roles.ANONYMOUS);
	}

    public static List<Roles> getRolesByResourcePath(String jspName) {
        List<Roles> roles = roleByResourcePath.get(jspName);
        return roles != null ? roles : Arrays.asList(Roles.ANONYMOUS);
    }



	

}