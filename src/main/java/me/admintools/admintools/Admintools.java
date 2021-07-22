package me.admintools.admintools;

import me.admintools.admintools.commands.*;
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
        getCommand("heal").setExecutor(new heal());
        getCommand("feed").setExecutor(new feed());
        getCommand("nick").setExecutor(new nick());
        getCommand("gmode").setExecutor(new gmode());
        getCommand("compasstarget").setExecutor(new compasstarget());
        getCommand("setspawn").setExecutor(new setspawn());
        getCommand("day").setExecutor(new day());
        getCommand("night").setExecutor(new night());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[AdminTools] Disabled!");
    }
}
