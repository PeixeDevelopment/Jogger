package main.java.com.jogger.joggerMisc;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JoggerMisc {

    public static String capitalizeFIrstLetter(String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
    }

}
