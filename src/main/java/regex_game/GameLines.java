package regex_game;

import java.util.Random;

public class GameLines {
    private static final String[] possibleGameIntros = {
            "Welcome to 'bAdventure'\n" +
                    "You find yourself in a room. What will you do?",
            "Welcome to Adventure b\n" +
                    "You find yourself in a room. What are you gonna do?",
            "Welcome to bAdventure'\n" +
                    "You find yourself in a dark foreboding room or maybe it's brightly lit. Whatever you're into.",
            "Welcome to 'blAdderventure'\n" +
                    "You find yourself kinda of needing to go to the loo but like no rush, but ahh it's not comfortable either, oooh",
            "Adventube to Welcome\n" +
                    "find yourself, what will the room do?"
    };
    static final String gameIntro = possibleGameIntros[new Random().nextInt(possibleGameIntros.length)];

    private static final String[] possibleGameExits = {
            "Well suit yourself",
            "No, PLEASE DON",
            "People today, no patience",
            "Yeah that's fair",
            "Oh thank god, I'm rid of them."
    };
    static String gameExit = possibleGameExits[new Random().nextInt(possibleGameExits.length)];

    static final String gameExitCommand = "exit game";



}
