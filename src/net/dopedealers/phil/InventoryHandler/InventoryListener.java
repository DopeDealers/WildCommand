package net.dopedealers.phil.InventoryHandler;

import net.dopedealers.phil.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener
{
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)e.getWhoClicked();
        final ItemStack is = e.getCurrentItem();
        final Inventory inv = e.getClickedInventory();
        if (inv == null || is == null) {
            return;
        }
        if (inv.getTitle().equalsIgnoreCase(Utils.color("&4&lWild"))) {
            e.setCancelled(true);
            InventoryManager.getInstance().useWild(is, player);
        }
    }
}
