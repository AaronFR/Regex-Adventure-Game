package regex_game;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GameUtil {

    static Boolean findByPattern(String regexPattern, String input) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
