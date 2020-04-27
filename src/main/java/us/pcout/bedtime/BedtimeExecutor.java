package us.pcout.bedtime;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BedtimeExecutor implements CommandExecutor {
    private Bedtime bedtime;

    public BedtimeExecutor(Bedtime plugin) {
        bedtime = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (bedtime.getServer().getWorld(Bedtime.world).getTime() < 13000) {
                player.sendMessage(Bedtime.prefix + "command only accessible at night.");
                return true;
            }

//            player.sendMessage(Bedtime.prefix + (bedtime.getMajority() - bedtime.getSleepers()) + " more players needed to skip to morning.");
            return true;
        } else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;

//            consoleCommandSender.sendMessage(Bedtime.prefix + "Players in world: " + ChatColor.AQUA
//                    + bedtime.getServer().getWorld(Bedtime.world).getPlayers().size() + ChatColor.WHITE + " Sleeping players: " + ChatColor.AQUA
//                    + bedtime.getSleepers() + ChatColor.WHITE + " Players needed for a majority: " + ChatColor.AQUA + bedtime.getMajority());
        }
        return false;
    }
}
