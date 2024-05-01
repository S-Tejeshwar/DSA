package Recursion;

public class SubSet {

    public static void main(String[] args) {
        findSubset("", "abcd");
    }

    public static void findSubset(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        findSubset(p+c, up.substring(1));
        findSubset(p, up.substring(1));
    }
}
