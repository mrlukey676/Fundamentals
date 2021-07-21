package me.admintools.admintools.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("admintools.gmode")){
                if(args.length == 0){
                    player.sendMessage(ChatColor.RED + "You must provide a number!");
                }else{
                    if(args[0].equals("1")){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.AQUA + "Set your gamemode to " + ChatColor.GOLD + player.getGameMode());
                    }else if(args[0].equals("0")){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.AQUA + "Set your gamemode to " + ChatColor.GOLD + player.getGameMode());
                    }else if(args[0].equals("2")){
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(ChatColor.AQUA + "Set your gamemode to " + ChatColor.GOLD + player.getGameMode());
                    }else if(args[0].equals("3")){
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ChatColor.AQUA + "Set your gamemode to " + ChatColor.GOLD + player.getGameMode());
                    }
                }
            }
        }
        return false;
    }
}
