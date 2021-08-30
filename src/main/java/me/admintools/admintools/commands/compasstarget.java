package me.admintools.admintools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class compasstarget implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.compasstarget")){
                player.setCompassTarget(player.getLocation());
                player.sendMessage(ChatColor.AQUA + "Set compass target to your location.");
            }
        }
        return false;
    }
}
