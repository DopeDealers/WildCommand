package net.dopedealers.phil.InventoryHandler;

import net.dopedealers.phil.utils.LocationsUtil;
import net.dopedealers.phil.utils.Utils;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import net.dopedealers.phil.*;
import org.bukkit.*;

public class InventoryManager
{
    private static InventoryManager INSTANCE;

    public static InventoryManager getInstance() {
        if (InventoryManager.INSTANCE == null) {
            InventoryManager.INSTANCE = new InventoryManager();
        }
        return InventoryManager.INSTANCE;
    }

    public void useWild(final ItemStack is, final Player player) {
        if (is.getType() != Material.WOOL) {
            return;
        }
        int amount = 0;
        int min = 0;
        int max = 0;
        switch (is.getDurability()) {
            case 5: {
                amount = 5000;
                min = 1000;
                max = 2000;
                break;
            }
            case 1: {
                amount = 10000;
                min = 3000;
                max = 5000;
                break;
            }
            case 14: {
                amount = 25000;
                min = 5001;
                max = 8000;
                break;
            }
        }
        player.closeInventory();
        if (Registry.economy.withdrawPlayer((OfflinePlayer)player, (double)amount).transactionSuccess()) {
            final Location location = LocationsUtil.getInstance().getRandomLocation(min, max);
            player.teleport(location);
            player.sendMessage(Utils.color("&4Wild &8> &7&oYou have randomly teleported."));
            player.sendMessage(Utils.color("&4Wild &8> &c&l-$" + amount));
            return;
        }
        player.sendMessage(Utils.color("&4Wild &8> &cYou don't have enough money!"));
    }
}

