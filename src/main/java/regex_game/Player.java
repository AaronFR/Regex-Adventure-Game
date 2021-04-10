package regex_game;

import regex_game.Verbs.Verb;
import java.util.Random;

class Player {
    private final String[] possibleDescriptions = {
            "A particularly remarkable Human",
            "A particularly tall Dwarf",
            "A particularly small Giant\nalso you smell like vinegar",
            "A particularly weak Orc",
            "A very 'down to earth' Elf",
            "A hairless gorilla",
            "A mutant double legged mermaid",
            "A 99¢ vanilla milkshake somehow shaped into the form of a man",
            "An evil, mischievous worm\nNo. You're literally an earth-worm",
            "A giant replica of the Colossus of Rhodes just prior to it's destruction circa BCE 226"
    };
    String description = possibleDescriptions[new Random().nextInt(possibleDescriptions.length)];

    void runVerb(Verb verb) {
        switch (verb) {
            case LOOK:
                System.out.println(this.look());
                break;
            case USE:
                System.out.println(this.use());
                break;
            default:
                System.out.println("Yeah what about you?");
        }
    }

    String look() {
        return description;
    }
    String use() {
        return "...dude";
    }

}
