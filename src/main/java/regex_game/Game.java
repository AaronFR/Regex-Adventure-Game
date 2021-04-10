package regex_game;

import static regex_game.GameLines.gameExit;
import static regex_game.GameLines.gameExitCommand;
import static regex_game.GameLines.gameIntro;
import static regex_game.Nouns.parseForNoun;
import static regex_game.Verbs.parseForVerb;

import regex_game.Nouns.Noun;
import regex_game.Verbs.Verb;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        System.out.println(gameIntro);

        Room room = new Room();
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;

        while (!exitGame) {
            String input = scanner.nextLine().toLowerCase();
            Verb verb = parseForVerb(input);
            Noun noun = parseForNoun(input);

            if (Noun.ROOM.equals(noun) && verb != null) {
                room.runVerb(verb);
            }
            if (Noun.PLAYER.equals(noun) && verb != null) {
                player.runVerb(verb);
            }

            if (gameExitCommand.equals(input)) {
                input = "";
                exitGame = true;
                System.out.println(gameExit);
            }
        }
    }

}
