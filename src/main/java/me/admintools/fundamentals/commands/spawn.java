package me.admintools.fundamentals.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            World w = player.getWorld();
            Location spawn = new Location(getServer().getWorld("world"),0,255,0);
            if(player.hasPermission("fundamentals.spawn")){
                if(args.length == 0){
                    player.teleport(spawn.getWorld().getSpawnLocation());
                    player.sendMessage(ChatColor.AQUA + "You have been sent to spawn!");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    target.teleport(spawn.getWorld().getSpawnLocation());
                    target.sendMessage(ChatColor.AQUA + "You have been sent to spawn!");
                    player.sendMessage(ChatColor.GOLD + target.getDisplayName() + ChatColor.AQUA + " has been sent to spawn!");
                }
            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to go to spawn!");
            }
        }else{
            System.out.println("This command must be run by a player!");
        }
        return false;
    }
}
