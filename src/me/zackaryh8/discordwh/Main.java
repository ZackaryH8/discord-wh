package me.zackaryh8.discordwh;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    PluginManager pm = getServer().getPluginManager();
    PluginDescriptionFile pdfFile = this.getDescription();
    DiscordEmbeds embed = new DiscordEmbeds(this);

    private final PlayerListener playerListener = new PlayerListener(this);

    @Override
    public void onDisable() {
        getLogger().info(pdfFile.getName() + " version " + pdfFile.getVersion() + " was disabled!");
    }

    @Override
    public void onEnable() {
        pm.registerEvents(playerListener, this);

        embed.ServerStarted(this.getConfig().getString("server-ip"));
        getLogger().info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
    }

}
