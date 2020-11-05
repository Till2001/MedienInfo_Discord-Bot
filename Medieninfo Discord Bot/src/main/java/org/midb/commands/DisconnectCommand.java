package org.midb.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.midb.bot.Bot;

public class DisconnectCommand implements MessageCreateListener{

	private Bot b;
	public DisconnectCommand(Bot pB) {
		b = pB;
	}
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if(event.getMessageContent().equalsIgnoreCase("!Disconnect")) {
			b.Disconnect();
		}
	}

}
