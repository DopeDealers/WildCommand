package net.dopedealers.phil.InventoryHandler.inventory;

import net.dopedealers.phil.utils.ItemBuilder;
import net.dopedealers.phil.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class WildInventory extends BukkitRunnable
{
    private final int[] numbers;
    private final Player player;
    private final Inventory inv;
    private int current;

    public WildInventory(final Player player) {
        this.numbers = new int[] { 3, 4, 5, 2, 6, 1, 7, 0, 8, 9, 17, 18, 26, 19, 25, 20, 24, 21, 22, 23 };
        this.current = -1;
        this.player = player;
        this.inv = player.getOpenInventory().getTopInventory();
    }

    public void run() {
        if (!this.player.getOpenInventory().getTopInventory().getTitle().equalsIgnoreCase(Utils.color("&4&lWild"))) {
            this.player.openInventory(this.inv);
        }
        ++this.current;
        if (this.current >= 6) {
            this.inv.setItem(11, new ItemBuilder(Material.WOOL, 5).setName("&a&l1000 to 2000").setLore("&8> &ePrice: &7&o$5000").getStack());
            this.inv.setItem(13, new ItemBuilder(Material.WOOL, 1).setName("&6&l3000 to 5000").setLore("&8> &ePrice: &7&o$10000").getStack());
            this.inv.setItem(15, new ItemBuilder(Material.WOOL, 14).setName("&4&l5000 to 8000").setLore("&8> &ePrice: &7&o$25000").getStack());
            this.cancel();
            return;
        }
        final int id = new Random().nextInt(15);
        for (int i = 0; i < this.numbers.length; ++i) {
            this.inv.setItem(this.numbers[i], new ItemBuilder(Material.STAINED_GLASS_PANE, id).setName(" ").getStack());
        }
        this.player.updateInventory();
    }
}
