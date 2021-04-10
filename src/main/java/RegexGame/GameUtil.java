package RegexGame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameUtil {

    static Boolean findByPattern(String regexPattern, String input) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
