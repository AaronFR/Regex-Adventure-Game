package RegexGame;

import static RegexGame.GameLines.gameExit;
import static RegexGame.GameLines.gameExitCommand;
import static RegexGame.GameLines.gameIntro;
import static RegexGame.Nouns.parseForNoun;
import static RegexGame.Verbs.parseForVerb;

import RegexGame.Nouns.Noun;
import RegexGame.Verbs.Verb;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        System.out.println(gameIntro);

        Room room = new Room();
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        Boolean exitGame = false;
        String input = null;

        while (!exitGame) {
            input = scanner.nextLine().toLowerCase();

            Verb verb = parseForVerb(input);
            Noun noun = parseForNoun(input);

            if (Noun.ROOM.equals(noun)) {
                room.runVerb(verb);
            }
            if (Noun.PLAYER.equals(noun)) {
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
