package net.dopedealers.phil.api;

import org.bukkit.command.*;

public abstract class CommandFactory
{
    private final String name;
    private final String permission;

    public CommandFactory(final String name, final String permission) {
        this.name = name;
        this.permission = permission;
    }

    public CommandFactory(final String name) {
        this.name = name;
        this.permission = "";
    }

    public String getName() {
        return this.name;
    }

    public String getPermission() {
        return this.permission;
    }

    public abstract void execute(final CommandSender p0, final String[] p1);
}
