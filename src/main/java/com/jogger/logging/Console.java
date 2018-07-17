package main.java.com.jogger.logging;

import main.java.com.jogger.channel.*;
import main.java.com.jogger.joggerMisc.JoggerMisc;

import java.util.stream.Collectors;

public class Console {

    public static Channel currentChannel = Channel.defaultChannel;

    public static void setChannel(String newChannel) {
        setChannel(getChannel(newChannel));
    }

    public static void setChannel(Channel newChannel) {
        System.out.println("{ Jogger } Changing channel from " + currentChannel.channelName + " to " + newChannel.channelName);
        currentChannel = newChannel;
        newChannel.showUnreadMessages();
    }

    public static Channel getChannel(String channelName) {
        return Channel.channels.stream().filter(channel -> channel.channelName.equals(channelName)).collect(Collectors.toList()).get(0);
    }

    public static Channel createChannel(String name, LogLevel logLevel)  {
        return Channel.createChannel(name, logLevel);
    }

    public static void print(String text) {
        currentChannel.print(text);
    }

    public static void printLn(String text) {
        currentChannel.printLn(text);
    }

    public static void print(String text, LogLevel level) {
        currentChannel.print(text, level);
    }

    public static void printLn(String text, LogLevel level) {
        currentChannel.printLn(text, level);
    }

    public static void print(PrintMessage message) {
        currentChannel.print(message);
    }



}
