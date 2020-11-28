package count;

import sort.Sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class Count implements Sort {

    @Override
    public int[] sort(int[] args) {
        int bias, min = args[0], max = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] > max)
                max = args[i];
            if (args[i] < min)
                min = args[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < args.length; i++) {
            bucket[args[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < args.length) {
            if (bucket[i] != 0) {
                args[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return args;
    }
}
