package me.admintools.admintools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class world implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("admintools.world")){
                if(args.length == 0){
                    player.sendMessage(ChatColor.RED + "This command requires an argument!");
                }else{
                    Location loc = new Location(Bukkit.getWorld(args[0]), 0, 255, 0);
                    player.teleport(loc);
                    player.teleport(player.getWorld().getSpawnLocation());
                }
            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to do this!");
            }
        }else{
            System.out.println("Only players can run this command!");
        }
        return false;
    }
}
