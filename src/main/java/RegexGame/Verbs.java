package RegexGame;

import static RegexGame.GameUtil.findByPattern;

import java.util.function.Function;

public class Verbs {

    public enum Verb {

        LOOK (b -> findByPattern("(\\bl*o+k+\\b|\\bs+e+\\b|\\bv+i*e*w+\\b|\\bp+e+r+c*e*i*v*e+\\b)", b)),
        USE (b -> findByPattern("(\\bu+s+e*\\b)", b));

        private final Function<String,Boolean> validPatterns ;
        Verb(Function<String,Boolean> validPatterns) {
            this.validPatterns = validPatterns;
        }

        public Boolean parse(String x) {
            return validPatterns.apply(x);
        }
    }

    static Verb parseForVerb(String input) {
        Boolean isMatch;

        for (Verb verb: Verb.values()){
            isMatch = verb.parse(input);
            if (isMatch) {
                return verb;
            }
        }
        return null;
    }

}
