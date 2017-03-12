package by.htp.shop.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.shop.controller.command.impl.Localization;
import by.htp.shop.controller.command.impl.SignIn;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.SIGN_IN, new SignIn());
		commands.put(CommandName.LOCALIZATION, new Localization());
	}

	public Command getCommand(String name) {
		CommandName commandName = CommandName.valueOf(name.toUpperCase());

		return commands.get(commandName);

	}
}
