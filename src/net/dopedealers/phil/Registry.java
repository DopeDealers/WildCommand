package net.dopedealers.phil;


import net.dopedealers.phil.api.CommandFactory;
import net.dopedealers.phil.api.CommandManager;
import net.dopedealers.phil.utils.Utils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Registry extends JavaPlugin {

    public static Registry plugin;
    public static Economy economy;

    public static Registry getPlugin() {
        return Registry.plugin;
    }

    public void onEnable() {
        Registry.plugin = this;
        new CommandManager();
        this.setupEconomy();
    }
    public void onDisable() {
        Registry.plugin = null;
    }
    public boolean onCommand(final CommandSender s, final Command c, final String string, final String[] args) {
        final CommandFactory command = CommandManager.getCommand(c.getName());
        if (command == null) {
            return false;
        }
        if (s instanceof Player) {
            final Player player = (Player)s;
            if (command.getPermission().equals("") || player.hasPermission(command.getPermission())) {
                command.execute(s, args);
            }
            else {
                player.sendMessage(Utils.color("&cPermission &8> &7You don't have permission to do this!"));
            }
            return true;
        }
        command.execute(s, args);
        return true;
    }
    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (economyProvider != null) {
            Registry.economy = (Economy)economyProvider.getProvider();
        }
        return Registry.economy != null;
    }
    static {
        Registry.economy = null;
    }
}
