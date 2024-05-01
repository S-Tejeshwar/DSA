package sort;

import java.io.PrintStream;
import java.util.Arrays;

public class MergsSort {

    public static void main(String[] args) {
        int []arr = {200,-2, -3, -9, 10000, 7};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int []arr, int start, int end)
    {
        if (end == start) {
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr,mid+1, end);
        merge(arr, start, mid, end);
    }

    static void merge (int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int k = 0;
        int[] expected = new int[(end - start) + 1];
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]){
                expected[k] = arr[i];
                i++;
            } else {
                expected[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            expected[k] = arr[i];
            k++;
            i++;
        }
        while (j <= end) {
            expected[k] = arr[j];
            k++;
            j++;
        }
        for (int pointer = 0; pointer < expected.length; pointer++) {
            arr[start+pointer] = expected[pointer];
        }
    }
}
