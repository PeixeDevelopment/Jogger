package main.java.com.jogger.logging;

import main.java.com.jogger.channel.Channel;
import main.java.com.jogger.joggerMisc.JoggerMisc;
import main.java.com.jogger.logging.Console;
import main.java.com.jogger.logging.LogLevel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrintMessage {

    String text = "No Text";
    Boolean newLine = true;
    LogLevel logLevel = LogLevel.INFO;

    public PrintMessage(String text, LogLevel logLevel, Boolean newLine) {
        this.text = text;
        this.newLine = newLine;
        this.logLevel = logLevel;
    }

    public PrintMessage(String text, Boolean newLine) {
        this.text = text;
        this.newLine = newLine;
        this.logLevel = LogLevel.INFO;
    }

    public PrintMessage(String text, LogLevel logLevel) {
        this.text = text;
        this.logLevel = logLevel;
        this.newLine = true;
    }


    public PrintMessage(String text) {
        this.text = text;
        this.logLevel = LogLevel.INFO;
        this.newLine = true;
    }





    public void print() {
        if(logLevel.name().contains("ERROR"))
            if(newLine) System.err.println(format()); else System.err.print(format());
        else
            if(newLine) System.out.println(format()); else System.out.print(format());
    }

    public void print(Channel channel) {
        if(Console.currentChannel != channel) {
            channel.unreadMessages.add(this);
            return;
        }
        print();
    }

    private String format() {
        String date = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
        return "{" + JoggerMisc.capitalizeFIrstLetter(logLevel.name()) + "} " + text + " {at " + date + "}";
    }


}
