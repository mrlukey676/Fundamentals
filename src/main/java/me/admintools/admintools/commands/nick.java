package me.admintools.admintools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.nick")){
                if(args.length == 0){
                    player.setDisplayName(player.getPlayerListName());
                    player.sendMessage(ChatColor.AQUA + "Your name has been reset to " + player.getDisplayName());
                    }else{
                        if(player.getDisplayName().equals(player.getPlayerListName())){
                            player.setDisplayName(args[0]);
                            player.sendMessage(ChatColor.AQUA + "Your nickname is now " + ChatColor.GOLD + player.getDisplayName());
                    }
                }
            }

        }else{
            System.out.println("This command must be sent by a player!");
        }
        return false;
    }
}