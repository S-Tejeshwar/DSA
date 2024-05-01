package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetDuplicates {


    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        System.out.println(subset(arr));
    }
    private static List<List<Integer>> subset(int [] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i<arr.length; i++) {
            start = 0;
            if (i>0 && arr[i-1] == arr[i]) {
                start = end + 1;
            }
            end = result.size() - 1;
            for (int j = start; j<= end; j++) {
                List<Integer> inner = new ArrayList<>(result.get(j));
                inner.add(arr[i]);
                result.add(inner);
            }
        }
        return result;
    }
}
