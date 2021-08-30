package me.admintools.admintools.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class day implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            World w = player.getWorld();
            if(player.hasPermission("fundamentals.day")){
                w.setTime(1000);
                player.sendMessage(ChatColor.AQUA + "The time has been set to " + ChatColor.GOLD + "day!");
            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to change the time to day!");
            }
        }else{
            System.out.println("This command must be sent by a player!");
        }
        return false;
    }
}
