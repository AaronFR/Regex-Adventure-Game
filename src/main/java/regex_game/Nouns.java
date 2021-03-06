package regex_game;

import static regex_game.GameUtil.findByPattern;

import java.util.function.Function;

class Nouns {

    /* Constant Specific Method
        I see now this implementation has limitations.
        e.g will have to ask for "Object 1", "Person 1"
     */

    enum Noun {
        ROOM (b -> findByPattern("oo*m+\\b", b)),
        PLAYER (b -> findByPattern("(\\bm+e+\\b|\\bs+e+l+f*\\b|\\bp+l+a+y*e*r*\\b)", b)),
        CHARACTER_ONE(b -> findByPattern("(d+a*v*e+)", b));

        private final Function<String,Boolean> validPatterns;
        Noun(Function<String,Boolean> validPatterns) {
            this.validPatterns = validPatterns;
        }

        public Boolean parse(String x) {
            return validPatterns.apply(x);
        }
    }

    static Noun parseForNoun(String input) {
        boolean isMatch;

        for (Noun noun: Noun.values()){
            isMatch = noun.parse(input);
            if (isMatch) {
                return noun;
            }
        }
        return null;
    }
}
