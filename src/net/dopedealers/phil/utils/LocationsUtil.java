package net.dopedealers.phil.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class LocationsUtil
{
    private static LocationsUtil INSTANCE;

    public static LocationsUtil getInstance() {
        if (LocationsUtil.INSTANCE == null) {
            LocationsUtil.INSTANCE = new LocationsUtil();
        }
        return LocationsUtil.INSTANCE;
    }

    public Location getRandomLocation(final int min, final int max) {
        double x = 0.0;
        double z = 0.0;
        do {
            x = Utils.getRandom(min, max);
        } while (x == 0.0 || x > max || x < -max);
        do {
            z = Utils.getRandom(min, max);
        } while (z == 0.0 || z > max || z < -max);
        if (Utils.getRandom() > 50) {
            z -= z * 2.0;
        }
        if (Utils.getRandom() > 50) {
            x -= x * 2.0;
        }
        final Location location = new Location(Bukkit.getWorld("world"), x, 60.0, z);
        final Block high = location.getWorld().getHighestBlockAt(location);
        location.setY((double)high.getY());
        return location;
    }
}

