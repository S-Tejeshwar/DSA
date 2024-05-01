package Recursion;

import javax.swing.*;

public class Permutations {

    public static void main(String[] args) {
        permutations("","abc");
    }
    public static void permutations(String p, String up)
    {
      if(up.isEmpty()) {
          System.out.println(p);
          return;
      }
      Character c = up.charAt(0);
      for (int i = 0; i <= p.length(); i++){
          String left = p.substring(0,i);
          String right = p.substring(i,p.length());
          permutations(left+c+right, up.substring(1));
      }
    }
}