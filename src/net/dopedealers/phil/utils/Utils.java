package net.dopedealers.phil.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {

    private static final Random random;

    public static String color(final String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    public static int getRandom() {
        return Utils.random.nextInt(100);
    }

    public static int getRandom(final int min, final int max) {
        return Utils.random.nextInt(max - min) + min;
    }

    public static String getRemainingTime(final long time) {
        final long left = time - System.currentTimeMillis();
        if (left < 0L) {
            return null;
        }
        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(left);
        seconds %= 60;
        int minutes = (int)TimeUnit.MILLISECONDS.toMinutes(left);
        minutes %= 60;
        final int hours = (int)TimeUnit.MILLISECONDS.toHours(left);
        final int days = (int)TimeUnit.MILLISECONDS.toDays(left);
        if (days > 0) {
            return String.valueOf(days) + "d " + hours + "h " + minutes + "m " + seconds + "s";
        }
        if (hours > 0) {
            return String.valueOf(hours) + "h " + minutes + "m " + seconds + "s";
        }
        if (minutes > 0) {
            return String.valueOf(minutes) + "m " + seconds + "s";
        }
        return String.valueOf(seconds) + "s";
    }
    static {
        random = new Random();
    }
}
