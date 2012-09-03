package org.realty.commands;

import org.realty.*;
import org.realty.commands.add.AddAdvertCommand;
import org.realty.commands.add.AddCommentCommand;
import org.realty.commands.add.AddUserCommand;
import org.realty.commands.all.AllAdvertCommand;
import org.realty.commands.all.AllCommentCommand;
import org.realty.commands.all.AllUserCommand;
import org.realty.commands.del.DelAdvertCommand;
import org.realty.commands.del.DelCommentCommand;
import org.realty.commands.del.DelUserCommand;
import org.realty.commands.other.*;

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
			put("changeLang", new ChangeLangCommand());
			put("indexGuest", new IndexGuestCommand());
			put("LogOut", new LogOutCommand());
            put("userPage", new UserPageCommand());
            put("advertPage", new AdvertPageCommand());
		}
	};

  private static final List<Roles> ALL_ROLES = Arrays.asList(Roles.LOGGED, Roles.ADMIN, Roles.ANONYMOUS);
  private static final List<Roles> LOG_ADM = Arrays.asList(Roles.LOGGED, Roles.ADMIN);
    private static Map<String, List<Roles>> roleByCommand = new HashMap<String, List<Roles>>() {
        {
            put("addUser", ALL_ROLES);
            put("allUser",  LOG_ADM);
            put("delUser",  LOG_ADM);
            put("addAdvert",  LOG_ADM);
            put("allAdvert",  LOG_ADM);
            put("delAdvert", LOG_ADM);
            put("addComment", LOG_ADM);
            put("allComment", ALL_ROLES);
            put("delComment", LOG_ADM);
            put("signIn", Arrays.asList(Roles.ANONYMOUS));
            put("changeLang", ALL_ROLES);
            put("indexGuest", Arrays.asList(Roles.ADMIN, Roles.ANONYMOUS));
            put("LogOut", LOG_ADM);
            put("userPage", LOG_ADM);
            put("advertPage", LOG_ADM);
        }
    };



    private static Map<String, List<Roles>> roleByResourcePath = new HashMap<String, List<Roles>>() {
        {
            put("User.jsp", Arrays.asList(Roles.ADMIN));
            put("index.jsp",   ALL_ROLES);
            put("Advert.jsp",  Arrays.asList(Roles.LOGGED));
            put("Comment.jsp",  Arrays.asList(Roles.LOGGED));
            put("Authentication.jsp",  Arrays.asList(Roles.ANONYMOUS));
            put("RealtyServlet" , Arrays.asList(Roles.ADMIN, Roles.ANONYMOUS));
            put("UserPage.jsp", LOG_ADM);
            put("AdvertPage.jsp", LOG_ADM);
            put("RegistrationPage.jsp", Arrays.asList(Roles.ANONYMOUS));
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