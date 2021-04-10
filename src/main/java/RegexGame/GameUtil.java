package RegexGame;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameUtil {

    public enum DetectVerb {

        LOOK (b -> findByPattern("(l*o+k+|s+e+|v+i*e*w+|p+e+r+c*e*i*v*e+)", b)),
        USE (b -> findByPattern("(u+s+e*)", b));

        private final Function<String,Boolean> validPatterns ;
        DetectVerb(Function<String,Boolean> validPatterns) {
            this.validPatterns = validPatterns;
        }

        public Boolean compute(String x) {
            return validPatterns.apply(x);
        }
    }

    public enum DetectTopic {
        /* Constant Specific Method
            I see now this implementation has limitations.
            e.g will have to ask for "Object 1", "Person 1"
         */

        ROOM (b -> findByPattern("oo*m+", b)),
        PLAYER (b -> findByPattern("(m+e+|s+e+l+f*|p+l+a+y*e*r*)", b));

        private final Function<String,Boolean> validPatterns ;
        DetectTopic(Function<String,Boolean> validPatterns) {
            this.validPatterns = validPatterns;
        }

        public Boolean compute(String x) {
            return validPatterns.apply(x);
        }
    }

    private static Boolean findByPattern(String regexPattern, String input) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
