package RegexGame;

import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    public static void main(String[] args) {
        // INITIAL: should be static imports
        System.out.println("Welcome to 'Text Ad Venture'");
        System.out.println("\nYou find yourself in a room. What will you do?");

        Room room = new Room();
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        String verb = parseForVerb(input);
        String noun = parseForNoun(input);

        // INITIAL: more flexible implementation
        if (noun.equals("room")) {
            if (verb.equals("look")) {
                System.out.println(room.look());
            }
        }
        if (noun == "player") {
            if (verb == "look") {
                System.out.println(player.look());
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

        if(DetectTopic.ROOM.compute(input)) {
            output = "room";
        }
        if(DetectTopic.PLAYER.compute(input)) {
            output = "player";
        }
        return output;
    }

    public enum DetectTopic { // Constant Specific Method
        /* I see now this implementation has limitations.
            e.g will have to ask for "Object 1", "Person 1"
         */
        ROOM (b -> findByPattern("o*m+", b)),
        PLAYER (b -> findByPattern("(m+e+|s*e*l*f+|p*l*a*y*e*r+)", b));

        private final Function<String,Boolean> validPatterns ;
        DetectTopic(Function<String,Boolean> validPatterns) {
            this.validPatterns = validPatterns;
        }

        private static Boolean findByPattern(String regexPattern, String input) {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(input);

            return matcher.find();
        }

        public Boolean compute(String x) {
            return validPatterns.apply(x);
        }
    }

}
