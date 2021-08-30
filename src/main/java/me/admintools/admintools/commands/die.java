package me.admintools.admintools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class die implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.die")){
                if(args.length == 0){
                    player.setHealth(0);
                    player.sendMessage(ChatColor.AQUA + "You have killed yourself!");
                    player.sendMessage(ChatColor.ITALIC + "Note - To kill other players, do '/die <PLAYERNAME>'");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player){
                        target.sendMessage(ChatColor.AQUA + "You have been killed by " + ChatColor.GOLD + player.getDisplayName());
                        target.setHealth(0);
                        player.sendMessage(ChatColor.GOLD + target.getDisplayName() + ChatColor.AQUA + " has been killed.");
                    }else{
                        player.sendMessage(ChatColor.AQUA + "Player not found!");
                    }
                }
            }else{
                player.sendMessage(ChatColor.AQUA + "You lack the required permission to kill!");
            }
        }else{
            System.out.println("This command needs to be sent by a player!");
        }


        return false;
    }
}
