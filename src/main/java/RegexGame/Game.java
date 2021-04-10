package RegexGame;

import static RegexGame.Nouns.parseForNoun;
import static RegexGame.Verbs.parseForVerb;

import RegexGame.Nouns.Noun;
import RegexGame.Verbs.Verb;
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

            Verb verb = parseForVerb(input);
            Noun noun = parseForNoun(input);

            // INITIAL: more flexible implementation -> Send to each object (Should not have double if statements)
            if (Noun.ROOM.equals(noun)) {
                switch (verb) {
                    case LOOK:
                        System.out.println(room.look());
                        break;
                    case USE:
                        System.out.println(room.use());
                        break;
                    default:
                        System.out.println("Yes, Room. Very Good");
                }
            }
            if (Noun.PLAYER.equals(noun)) {
                switch (verb) {
                    case LOOK:
                        System.out.println(player.look());
                        break;
                    case USE:
                        System.out.println(player.use());
                        break;
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

}
