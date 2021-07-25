package me.admintools.admintools.commands;

import me.admintools.admintools.files.warps;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            World w = player.getWorld();
            if(player.hasPermission("admintools.warp")){
                String x = warps.get().getStringList(args[0]).get(1);
                String y = warps.get().getStringList(args[0]).get(2);
                String z = warps.get().getStringList(args[0]).get(3);

                Location location = new Location(x, y, z);

                player.teleport(player.getLocation());
        }
        }else{
            System.out.println("This command must be sent by a player!");
        }
        return false;
    }
}
