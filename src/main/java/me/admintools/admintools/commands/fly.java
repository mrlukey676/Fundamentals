package me.admintools.admintools.commands;

import org.bukkit.Bukkit;
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
                    if(player.hasPermission("admintif(player.hasPermission(\"admintools.fly\")){ools.fly")){
                        if(args.length == 0){
                            if(player.isFlying()){
                                player.setAllowFlight(false);
                                player.sendMessage(ChatColor.AQUA + "Disabled fly for user " + ChatColor.GOLD + player.getDisplayName());
                            }else{
                                player.setAllowFlight(true);
                                player.sendMessage(ChatColor.AQUA + "Enabled fly for user " + ChatColor.GOLD + player.getDisplayName());
                            }
                        }else{
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if(target instanceof Player){
                                if(target.isFlying()){
                                    target.setAllowFlight(false);
                                    player.sendMessage(ChatColor.AQUA + "Disabled fly for user " + ChatColor.GOLD + target.getDisplayName());
                                    target.sendMessage(ChatColor.AQUA + "You have been removed from fly mode by " + ChatColor.GOLD + player.getDisplayName());
                                }else{
                                    target.setAllowFlight(true);
                                    player.sendMessage(ChatColor.AQUA + "Enabled fly for user " + ChatColor.GOLD + target.getDisplayName());
                                    target.sendMessage(ChatColor.AQUA + "You have been put into fly mode by " + ChatColor.GOLD + player.getDisplayName());

                                }
                            }else{
                                player.sendMessage(ChatColor.AQUA + "Player not found!");
                            }
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
