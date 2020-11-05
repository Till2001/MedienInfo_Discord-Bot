package org.midb.bot;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Bitte ein Bot-Token angeben!");
        	return;
        }
        Bot b = new Bot(args[0]);
        b.init();
    }
}
