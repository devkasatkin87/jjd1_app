package utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    // Receives IP address in String format and checks its validity with regular expressions.
    // Returns true if IP is validity and false if IP is not validity.
    public boolean validateIp(String ip) {
        String regex = "\\d+\\.\\d+\\.\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    // Checks if the IP is in the blacklist of IPs
    // Returns true if IP in BL and false if IP is not in BL.
    public boolean checkFromBL(String ip, List<String> blacklistIP) {
        for (String element:
             blacklistIP) {
            if (ip.equals(element)) {
                return false;
            }
        }
        return true;
    }
}
