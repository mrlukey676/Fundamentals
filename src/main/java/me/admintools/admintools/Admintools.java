package me.admintools.admintools;

import me.admintools.admintools.commands.*;
import me.admintools.admintools.files.warps;
import org.bukkit.plugin.java.JavaPlugin;

public final class Admintools extends JavaPlugin {

    public static Admintools plugin;
    String version = getConfig().getString("plugin-version");

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        warps.setup();
        warps.get().addDefault("DO NOT WRITE IN HERE", ("DO NOT WRITE IN HERE"));
        warps.get().options().copyDefaults(true);
        warps.save();
        System.out.println("[Fundamentals] Loaded version " + version);
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
        getCommand("spawn").setExecutor(new spawn());
        getCommand("world").setExecutor(new world());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[AdminTools] Disabled!");
    }
}
