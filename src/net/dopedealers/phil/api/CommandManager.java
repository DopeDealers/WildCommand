package net.dopedealers.phil.api;

import net.dopedealers.phil.command.WildCMD;

import java.util.ArrayList;
import java.util.List;

public class CommandManager
{
    private static List<CommandFactory> commands;

    public CommandManager() {
        if (CommandManager.commands == null) {
            CommandManager.commands = new ArrayList<CommandFactory>();
        }

        CommandManager.commands.add(new WildCMD());

    }

    public static CommandFactory getCommand(final String name) {
        for (final CommandFactory commands : getCommands()) {
            if (commands.getName().equalsIgnoreCase(name)) {
                return commands;
            }
        }
        return null;
    }

    public static List<CommandFactory> getCommands() {
        return CommandManager.commands;
    }
}