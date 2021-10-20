package me.admintools.fundamentals.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setspawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.setspawn")){
                if(args.length == 0){
                    player.setBedSpawnLocation(player.getLocation());
                    player.sendMessage(ChatColor.AQUA + "Spawn set to your current location!");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    target.setBedSpawnLocation(player.getLocation());
                    player.sendMessage(ChatColor.AQUA + "Set " + ChatColor.GOLD + target.getDisplayName() + ChatColor.AQUA + "'s spawn point to your location.");
                    target.sendMessage(ChatColor.AQUA + "Your spawn point has been changed!");
                }

            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to set spawn!");
            }
        }else{
            System.out.println("This command must be sent by a player!");
        }
        return false;
    }
}
