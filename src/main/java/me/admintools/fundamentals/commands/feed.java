package me.admintools.fundamentals.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.feed")){
                if(args.length == 0){
                    player.sendMessage(ChatColor.AQUA + "You have been fed!");
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    target.sendMessage(ChatColor.AQUA + "You have been fed by " + ChatColor.GOLD + player.getDisplayName());
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    player.sendMessage(ChatColor.AQUA + "Fed " + ChatColor.GOLD +target.getDisplayName());
                }
            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to feed!");
            }
        }else{
            System.out.println("Only players can send this command!");
        }
        return false;
    }
}
