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
            put("addUser", Arrays.asList(Roles.ANONYMOUS, Roles.ADMIN));
            put("allUser",  Arrays.asList(Roles.ADMIN,Roles.LOGGED));
            put("delUser",  Arrays.asList(Roles.ADMIN));
            put("addAdvert",  Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("allAdvert",  Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("delAdvert", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("addComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("allComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
            put("delComment", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("signIn", Arrays.asList(Roles.ANONYMOUS));
            put("indexGuest", Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
            put("LogOut", Arrays.asList(Roles.LOGGED, Roles.ADMIN));
            put("Authentication.jsp", Arrays.asList(Roles.ANONYMOUS));
            put("RealtyServlet?null", Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS));
        }
    };

	public static Command getCommand(String commandName) {

		Command command = commands.get(commandName);
		return command != null ? command : new IndexGuestCommand();
	}

	public static List<Roles> getRoles(String commandName) {
        List<Roles> roles;
        if(commandName.indexOf("addUser")!=-1)    {
            roles = role.get("addUser");
        }
        if(commandName.indexOf("allUser")!=-1)    {
            roles = role.get("allUser");
        }
        if(commandName.indexOf("delUser")!=-1)    {
            roles = role.get("delUser");
        }
        if(commandName.indexOf("addAdvert")!=-1)    {
            roles = role.get("addAdvert");
        }
        if(commandName.indexOf("allAdvert")!=-1)    {
            roles = role.get("allAdvert");
        }
        if(commandName.indexOf("delAdvert")!=-1)    {
            roles = role.get("delAdvert");
        }
        if(commandName.indexOf("addComment")!=-1)    {
            roles = role.get("addComment");
        }
        if(commandName.indexOf("allComment")!=-1)    {
            roles = role.get("allComment");
        }
        if(commandName.indexOf("delComment")!=-1)    {
            roles = role.get("delComment");
        }
        if(commandName.indexOf("signIn")!=-1)    {
         roles = role.get("signIn");
        }
        if(commandName.indexOf("indexGuest")!=-1)    {
           roles = role.get("indexGuest");
        }
        if(commandName.indexOf("LogOut")!=-1)    {
            roles = role.get("LogOut");
        }
        if(commandName.indexOf("LogOut")!=-1)    {
            roles = role.get("LogOut");
        }
        if(commandName.indexOf("RealtyServlet?null")!=-1)    {
            roles = role.get("RealtyServlet?null");
        }           else  roles=Arrays.asList(Roles.ANONYMOUS) ;

        return roles != null ? roles : new ArrayList<Roles>();
	}




	

}