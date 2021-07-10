package me.admintools.admintools;

import me.admintools.admintools.commands.die;
import me.admintools.admintools.commands.fly;
import me.admintools.admintools.commands.invincible;
import me.admintools.admintools.commands.vanish;
import org.bukkit.plugin.java.JavaPlugin;

public final class Admintools extends JavaPlugin {

    String version = getConfig().getString("plugin-version");

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("[AdminTools] Loaded version " + version);
        getCommand("fly").setExecutor(new fly());
        getCommand("vanish").setExecutor(new vanish());
        getCommand("invincible").setExecutor(new invincible());
        getCommand("die").setExecutor(new die());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[AdminTools] Disabled!");
    }
}
