package me.admintools.admintools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.heal")){
                if(args.length == 0){
                    player.sendMessage(ChatColor.AQUA + "You have been healed!");
                    player.setHealth(20);
                    player.setFoodLevel(20);
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    target.sendMessage(ChatColor.AQUA + "You have been healed by " + ChatColor.GOLD + player.getDisplayName());
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    player.sendMessage(ChatColor.AQUA + "Healed " + ChatColor.GOLD +target.getDisplayName());
                }
            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to heal!");
            }
        }else{
            System.out.println("Only players can send this command!");
        }
        return false;
    }
}
