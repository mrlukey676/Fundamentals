package me.admintools.admintools.commands;

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
            if(player.hasPermission("admintools.invincible")){
                if(player.isInvulnerable()){
                    player.setInvulnerable(false);
                    player.sendMessage(ChatColor.AQUA + "You are no longer invincible!");
                }else{
                    player.setInvulnerable(true);
                    player.sendMessage(ChatColor.AQUA + "You are now invincible!");

                }
            }
        }
        return false;
    }
}
