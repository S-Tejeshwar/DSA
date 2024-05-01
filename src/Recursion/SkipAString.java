package Recursion;

public class SkipAString {

    public static void main(String[] args) {
        String result = skipString("", "blahappleblahapplebro", "blah");
        System.out.println(result);
    }

    public static String skipString(String processed, String unprocessed, String key) {

        if (unprocessed.isEmpty()) {
            return "";
        }
        if (unprocessed.startsWith(key)) {
            return processed + skipString(processed, unprocessed.substring(key.length()), key);
        } else {
            return processed + unprocessed.charAt(0) + skipString(processed, unprocessed.substring(1), key);
        }
    }
}
