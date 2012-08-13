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
		}
	};

	public static Command getCommand(String commandName) {

		Command command = commands.get(commandName);
		return command != null ? command : new AllUserCommand();
	}





	

}