package regex_game;

import regex_game.Verbs.Verb;

class Room {

    void runVerb(Verb verb) {
        switch (verb) {
            case LOOK:
                System.out.println(this.look());
                break;
            case USE:
                System.out.println(this.use());
                break;
            default:
                System.out.println("Yes, Room. Very Good");
        }
    }

    String look() {
        return "Just a completely empty room... oh and you, I guess";
    }
    String use() {
        return "...Aren't you already?";
    }

}
