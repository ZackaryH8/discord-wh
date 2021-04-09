package me.zackaryh8.discordwh;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

/**
 * Handle player events (connect, disconnect, etc.)
 */
class PlayerListener implements Listener {
    DiscordEmbeds embed;

    public PlayerListener(Main instance) {
        embed = new DiscordEmbeds(instance);
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();

        embed.PlayerJoined(playerName);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();

        embed.PlayerLeft(playerName);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String deathMessage = event.getDeathMessage();

        embed.PlayerDeath(deathMessage);
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent event) {
        String playerName = event.getPlayer().getName();

        embed.PlayerBedEnter(playerName);
    }
}