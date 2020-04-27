package us.pcout.bedtime;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Bedtime extends JavaPlugin {
    private int sleepers;
    protected static String prefix = ChatColor.AQUA + "Bedtime: " + ChatColor.WHITE;
    protected static String world = "world";

    public Bedtime() {
        sleepers = 0;
    }

    public void sleep() {
        sleepers++;
        int majority = (int) Math.ceil(((double) getServer().getWorld(world).getPlayers().size()) / 2);
        if (sleepers >= majority) {
            getServer().getWorld(world).setTime(1000);
        }
    }

    public void wake() {
        sleepers--;
    }

    @Override
    public void onEnable() {
        this.getCommand("bedtime").setExecutor(new BedtimeExecutor(this));
        getServer().getPluginManager().registerEvents(new BedtimeListener(this), this);
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                if (getServer().getWorld(world).getTime() < 13000) {
                    sleepers = 0;
                }
            }
        }, 0L, 5000L);
    }
}
