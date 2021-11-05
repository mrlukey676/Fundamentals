package me.admintools.fundamentals.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getworld implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("fundamentals.getworld")){
                player.sendMessage("§aYour current world is §e" + player.getWorld().getName());
            }else{
                player.sendMessage("§cYou do not have permission to use this command!");
            }
        }
        return false;
    }
}
