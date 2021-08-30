package me.admintools.admintools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invincible implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("invincible")){
            Player player = (Player) sender;
            if(player.hasPermission("fundamentals.invincible")){
                if(args.length == 0){
                    if(player.isInvulnerable()){
                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.AQUA + "You are no longer invincible!");
                    }else{
                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.AQUA + "You are now invincible!");

                    }
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player){
                        if(target.isInvulnerable()){
                            target.setInvulnerable(false);
                            target.sendMessage(ChatColor.AQUA + "You are no longer invincible!");
                            player.sendMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.AQUA + " is no longer invincible!");
                        }else{
                            target.setInvulnerable(true);
                            target.sendMessage(ChatColor.AQUA + "You are now invincible!");
                            player.sendMessage(ChatColor.GOLD + target.getDisplayName() + ChatColor.AQUA + " is now invincible!");
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "Cannot find target!");
                    }
                }

            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to become invincible!");
            }
        }
        return false;
    }
}
