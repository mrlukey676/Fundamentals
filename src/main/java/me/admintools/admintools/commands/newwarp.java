package me.admintools.admintools.commands;

import me.admintools.admintools.files.warps;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class newwarp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            World w = player.getWorld();
            if(player.hasPermission("admintools.newwarp")){
                Location loc = player.getLocation();
                warps.get().addDefault(args[0], loc);
                warps.save();
                player.sendMessage(ChatColor.AQUA + "New warp set!");

            }else{
                player.sendMessage(ChatColor.RED + "You lack the required permission to set a new warp!");
            }
        }else{
            System.out.println("This command must be sent by a player!");
        }
        return false;
    }
}
