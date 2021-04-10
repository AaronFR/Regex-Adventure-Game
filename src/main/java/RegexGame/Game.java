package RegexGame;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    public static void main(String[] args) {
        // INITIAL: should be static imports
        System.out.println("Welcome to 'Text Ad Venture'");
        System.out.println("\nYou find yourself in a room. What will you do?");

        Room room = new Room();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        String verb = parseForVerb(input);
        String noun = parseForNoun(input);

        // INITIAL: more flexible implementation
        if (noun == "room") {
            if (verb == "look") {
                System.out.println(room.look());
            }

        }



    }

    // INITIAL: Obvious code duplication.
    private static String parseForVerb(String input) {
        String output = null;

        Pattern pattern = Pattern.compile("o*k++");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            output = "look";
        }
        return output;
    }

    private static String parseForNoun(String input) {
        String output = null;

        Pattern pattern = Pattern.compile("o*m+");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            output = "room";
        }
        return output;
    }

}
