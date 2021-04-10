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
        String input = scanner.nextLine().toLowerCase();

        String verb = parseForVerb(input);
        String noun = parseForNoun(input);

        // INITIAL: more flexible implementation
        if (noun.equals("room")) {
            if (verb.equals("look")) {
                System.out.println(room.look());
            }
            if (verb.equals("use")) {
                System.out.println(room.use());
            }
        }
        if (noun == "player") {
            if (verb == "look") {
                System.out.println(player.look());
            }
            if (verb.equals("use")) {
                System.out.println(player.use());
            }
        }

    }

    // INITIAL: Obvious code duplication.
    private static String parseForVerb(String input) {
        String output = null;

        if(DetectVerb.LOOK.compute(input)) {
            output = "look";
        }
        if(DetectVerb.USE.compute(input)) {
            output = "use";
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

}
