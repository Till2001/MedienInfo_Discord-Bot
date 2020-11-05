package org.midb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;


public class Main {

	private static Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Bitte ein Bot-Token angeben!");
            return;
        }

        // Debugging aktivieren
        FallbackLoggerConfiguration.setDebug(true);

        String token = args[0];

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        logger.info("Invite Link: " + api.createBotInvite());

        
        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }
}
