package us.pcout.bedtime;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedtimeListener implements Listener {
    private final Bedtime bedtime;

    public BedtimeListener(Bedtime plugin) {
        bedtime = plugin;
    }

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent event) {
        bedtime.sleep();
    }

    public void onPlayerWake(PlayerBedLeaveEvent event) {
        bedtime.wake();
    }
}
