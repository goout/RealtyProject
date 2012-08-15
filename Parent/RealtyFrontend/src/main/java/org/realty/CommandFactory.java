package org.realty;

import java.util.HashMap;
import java.util.Map;

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
		}
	};

	public static Command getCommand(String commandName) {

		Command command = commands.get(commandName);
		return command != null ? command : new AllUserCommand();
	}





	

}