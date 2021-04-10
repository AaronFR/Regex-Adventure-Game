package RegexGame;

import RegexGame.GameUtil.DetectTopic;
import RegexGame.GameUtil.DetectVerb;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        // INITIAL: should be static imports
        System.out.println("Welcome to 'Text Ad Venture'");
        System.out.println("\nYou find yourself in a room. What will you do?");

        Room room = new Room();
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);

        Boolean exitGame = false;
        String input = null;
        while (!exitGame) {
            input = scanner.nextLine().toLowerCase();

            String verb = parseForVerb(input);
            String noun = parseForNoun(input);

            // INITIAL: more flexible implementation -> Send to each object (Should not have double if statements)
            // Should be enums not Strings
            if ("room".equals(noun)) {
                switch (verb) {
                    case "look":
                        System.out.println(room.look());
                    case "use":
                        System.out.println(room.use());
                    default:
                        System.out.println("Yes, Room. Very Good");
                }
            }
            if ("player".equals(noun)) {
                switch (verb) {
                    case "look":
                        System.out.println(player.look());
                    case "use":
                        System.out.println(player.use());
                    default:
                        System.out.println("Yeah what about you?");
                }
            }

            if ("exit game".equals(input)) {
                input = "";
                exitGame = true;
                System.out.println("Well suit yourself");
            }
        }
    }

    // INITIAL: Obvious code duplication.
    private static String parseForVerb(String input) {
        String output = "";

        if(DetectVerb.LOOK.parse(input)) {
            output = "look";
        }
        if(DetectVerb.USE.parse(input)) {
            output = "use";
        }
        return output;
    }

    private static String parseForNoun(String input) {
        String output = "";

        if(DetectTopic.ROOM.parse(input)) {
            output = "room";
        }
        if(DetectTopic.PLAYER.parse(input)) {
            output = "player";
        }
        return output;
    }

}
