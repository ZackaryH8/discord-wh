package me.zackaryh8.discordwh;

import java.awt.*;
import java.io.IOException;


public class DiscordEmbeds {
    private final Main plugin;
    private final String webhookUrl;

    public DiscordEmbeds(Main instance) {
        plugin = instance;
        webhookUrl = plugin.getConfig().getString("webhookUrl");
    }

    private void urlCheck() {
        if (webhookUrl.isEmpty()) {
            plugin.getServer().getLogger().warning("Webhook URL is missing from config!");
        }
    }

    public void ServerStarted(String ip) {
        urlCheck();
        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);

        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Server Started")
                .setDescription("The server has successfully started, you can connect using the details below! Connecting with console for the first time? Click [here](https://www.youtube.com/watch?v=g8mHvasVHMs)")
                .addField("IP Address", ip, false)
                .addField("Java Port (PC)", "25565", true)
                .addField("Bedrock Port (Xbox, PS4, PE)", "19132", true)
                .setColor(Color.decode("#0071c7"))
        );

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlayerJoined(String playerName) {
        urlCheck();
        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);

        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Player Joined")
                .setDescription(playerName + " has joined the server!")
                .setColor(Color.decode("#0ba100"))
                .setThumbnail("https://minotar.net/avatar/" + playerName + ".png/100")
        );

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlayerLeft(String playerName) {
        urlCheck();
        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);

        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Player Left")
                .setDescription(playerName + " has left the server!")
                .setColor(Color.decode("#cc1f00"))
                .setThumbnail("https://minotar.net/avatar/" + playerName + ".png/100")
        );

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlayerDeath(String deathMessage) {
        urlCheck();
        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);

        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Player Died")
                .setDescription(deathMessage)
                .setColor(Color.decode("#cc1f00"))
                .setThumbnail("https://i.imgur.com/bMS3rSE.png")
        );

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlayerBedEnter(String playerName) {
        urlCheck();
        DiscordWebhook webhook = new DiscordWebhook(webhookUrl);

        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Player Entered Bed")
                .setDescription(playerName + " is now sleeping")
                .setColor(Color.decode("#b3302a"))
                .setThumbnail("https://i.imgur.com/XpVy0ra.png")
        );

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
