package me.admintools.admintools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("admintools.vanish")){
                if(player.isInvisible()){
                    player.setInvisible(false);
                    player.sendMessage(ChatColor.AQUA + "Disabled vanish for user " + ChatColor.GOLD + player.getDisplayName());
                }else{
                    player.setInvisible(true);
                    player.sendMessage(ChatColor.AQUA + "Enabled vanish for user " + ChatColor.GOLD + player.getDisplayName());
                }
            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to vanish!");
            }
        }else{
            System.out.println("'vanish' can only be run by players!");
        }
        return false;
    }
}
