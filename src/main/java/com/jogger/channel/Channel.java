package main.java.com.jogger.channel;

import main.java.com.jogger.logging.LogLevel;
import main.java.com.jogger.logging.PrintMessage;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    public static Channel defaultChannel = new Channel("default", LogLevel.INFO);
    public static List<Channel> channels = new ArrayList<Channel>();
    public List<PrintMessage> unreadMessages = new ArrayList<PrintMessage>();
    public String channelName = "default";
    public LogLevel logLevel = LogLevel.INFO;
    @Deprecated

    private Channel(String channelName, LogLevel logLevel) {
        this.channelName = channelName;
        this.logLevel = logLevel;
    }

    public void showUnreadMessages() {
        if(!unreadMessages.isEmpty()) {
            System.out.println("-> Unread Messages {" + unreadMessages.size() + "}");
            for(PrintMessage pm : unreadMessages) pm.print();
            System.out.println("-> End of unread messages {" + channelName + "}");
        }
    }

    public void print(String text) {
        new PrintMessage(text, false).print(this);
    }

    public void printLn(String text) {
        new PrintMessage(text, true).print(this);
    }

    public void print(String text, LogLevel level) {
        new PrintMessage(text, level, false).print(this);
    }

    public void printLn(String text, LogLevel level) {
        new PrintMessage(text, level,false).print(this);
    }

    public void print(PrintMessage message) {
        message.print(this);
    }

    public static Channel createChannel(String name, LogLevel logLevel)  {
        Channel channel = new Channel(name, logLevel);
        Channel.channels.add(channel);
        return channel;
    }

}