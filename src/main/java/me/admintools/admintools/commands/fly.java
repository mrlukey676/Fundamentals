package me.admintools.admintools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
                    if(player.hasPermission("admintools.fly")){
                        if(player.isFlying()){
                            player.setAllowFlight(false);
                            player.sendMessage(ChatColor.AQUA + "Disabled fly for user " + ChatColor.GOLD + player.getDisplayName());
                        }else{
                            player.setAllowFlight(true);
                            player.sendMessage(ChatColor.AQUA + "Enabled fly for user " + ChatColor.GOLD + player.getDisplayName());
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "You lack the required permission to fly!");
                    }
        }else{
            System.out.println("'fly' can only be run by a player entity");
        }
        return false;
    }
}
