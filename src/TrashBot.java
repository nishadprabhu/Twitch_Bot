import java.util.ArrayList;

import org.jibble.pircbot.PircBot;

public class TrashBot extends PircBot {

    public ArrayList<Memer> activePlayers;

    public TrashBot() {
        this.setName("nishadbot");
        this.activePlayers = new ArrayList<Memer>();
    }

    @Override
    public void onMessage(String channel, String sender, String login,
            String hostname, String message) {
        if (message.equalsIgnoreCase("!trash")) {
            this.sendMessage(channel, "Hi, I'm TrashBot!");
        }
        if (message.equalsIgnoreCase("!meme")) {
            boolean isActive = false;
            for (Memer temp : this.activePlayers) {
                if (temp.getNick().equals(sender)) {
                    isActive = true;
                    this.sendMessage(channel, sender + ", you have "
                            + temp.numPoints() + " meme points!");
                }
            }
            if (!isActive) {
                this.activePlayers.add(new Memer(sender));
                this.sendMessage(channel, sender
                        + ", you are added to the MEME TEAM :^). Get as many points as you can!");
            }
        }
        if (message.equalsIgnoreCase("!rankings")) {
            String top = "Top 5 Memers:\n" + this.activePlayers.get(0) + " - "
                    + this.activePlayers.get(0).numPoints() + " points\n";
            top += this.activePlayers.get(1) + " - "
                    + this.activePlayers.get(1).numPoints() + " points\n";
            top += this.activePlayers.get(2) + " - "
                    + this.activePlayers.get(2).numPoints() + " points\n";
            top += this.activePlayers.get(3) + " - "
                    + this.activePlayers.get(3).numPoints() + " points\n";
            top += this.activePlayers.get(4) + " - "
                    + this.activePlayers.get(4).numPoints() + " points";
            this.sendMessage(channel, top);
        }
        this.checkForMeme(sender, message);
        this.sortMemers();

    }

    public void sortMemers() {
        int swaps = 1;
        while (swaps > 0) {
            swaps = 0;
            for (int i = 0; i < this.activePlayers.size() - 1; i++) {
                if (this.activePlayers.get(i)
                        .compareTo(this.activePlayers.get(i + 1)) == -1) {
                    Memer temp = this.activePlayers.get(i);
                    Memer p1 = this.activePlayers.get(i);
                    Memer p2 = this.activePlayers.get(i + 1);
                    p1 = p2;
                    p2 = temp;
                    swaps++;
                }
            }
        }

    }

    public void checkForMeme(String sender, String message) {
        for (Memer temp : this.activePlayers) {
            if (temp.getNick().equals(sender)) {
                temp.addMeme(message);
            }
        }
    }

    @Override
    public void onDisconnect() {
        while (!this.isConnected()) {
            try {
                this.reconnect();
            } catch (Exception e) {
                System.out.println("Couldn't reconnect :(");
            }
        }
    }
}
