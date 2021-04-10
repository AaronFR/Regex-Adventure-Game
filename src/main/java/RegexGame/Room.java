package RegexGame;

import RegexGame.Verbs.Verb;

public class Room {

    public void runVerb(Verb verb) {
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

    public String look() {
        return "Just a completely empty room... oh and you, I guess";
    }
    public String use() {
        return "...Aren't you already?";
    }

}
