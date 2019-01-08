package net.dopedealers.phil.command;


import net.dopedealers.phil.InventoryHandler.inventory.WildInventory;
import net.dopedealers.phil.Registry;
import net.dopedealers.phil.api.CommandFactory;
import net.dopedealers.phil.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;

public class WildCMD extends CommandFactory
{
    public WildCMD() {
        super("wild");
    }

    @Override
    public void execute(final CommandSender sender, final String[] args) {
        if (!(sender instanceof Player)) {
            return;
        }
        final Player player = (Player)sender;
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, Utils.color("&4&lWild"));
        player.openInventory(inv);
        new WildInventory(player).runTaskTimer((Plugin) Registry.getPlugin((Class)Registry.class), 10L, 10L);
    }
}
