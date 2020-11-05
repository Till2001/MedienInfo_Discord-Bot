package org.midb.bot;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.midb.commands.DisconnectCommand;

public class Bot {
	
	private Logger logger;
	private DiscordApi api;
	public Bot(String token) {
		//Logger erstellen und den Fallbacklogger aktivieren
        FallbackLoggerConfiguration.setDebug(true);
        logger = LogManager.getLogger(Bot.class);
        

        //Bot starten
        api = new DiscordApiBuilder().setToken(token).login().join();
        logger.info("Invite Link: " + api.createBotInvite());
	}

	//Listener hinzufügen
	public void init() {
		logger.traceEntry();
		api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
        api.addMessageCreateListener(new DisconnectCommand(this));
	}

	//Bot beenden
	public void Disconnect() {
		logger.log(Level.ALL, "Der Bot wird beendet");
		api.disconnect();
		System.exit(0);
	}
}
