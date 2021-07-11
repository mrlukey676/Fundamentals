package me.admintools.admintools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyspeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("admintools.flyspeed")){
                if(args[0].equals("fast")){
                    player.setFlySpeed(10);
                }else if(args[0].equals("normal")){
                    player.setFlySpeed(1);
                }
            }else{
                player.sendMessage("You lack the required permission to change your flyspeed!");
            }
        }else{
            System.out.println("This command must be run by a player!");
        }
        return false;
    }
}
