package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetIterative {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(subset(arr));
    }

    private static List<List<Integer>> subset(int [] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : arr) {
            int n = result.size();
            for (int i = 0; i<n; i++) {
                List<Integer> inner = new ArrayList<>(result.get(i));
                inner.add(num);
                result.add(inner);
            }
        }
        return result;
    }
}
