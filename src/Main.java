import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

public class Main {

    public static void main(String[] args) {
        TrashBot bot = new TrashBot();
        bot.setVerbose(true);
        try {
            bot.connect("irc.twitch.tv", 6667,
                    "oauth:pjatgrnwf6lvc1y7d8gy7bvoai49qf");
        } catch (NickAlreadyInUseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IrcException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bot.joinChannel("#pl0xsaurus");
    }
}
