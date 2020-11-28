package merge;

import sort.Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Merge implements Sort {

    @Override
    public int[] sort(int[] args) {
        return mergeSort(args);
    }

    private int[] mergeSort(int[] args) {
        if (args.length < 2) return args;
        int mid = args.length / 2;
        int[] left = Arrays.copyOfRange(args, 0, mid);
        int[] right = Arrays.copyOfRange(args, mid, args.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, leftIndex = 0, rightIndex = 0; index < result.length; index++) {
            if (leftIndex >= left.length) {
                result[index] = right[rightIndex++];
            } else if(rightIndex >= right.length) {
                result[index] = left[leftIndex++];
            } else if(left[leftIndex] > right[rightIndex]){
                result[index] = right[rightIndex++];
            } else {
                result[index] = left[leftIndex++];
            }
        }
        return result;
    }
}
