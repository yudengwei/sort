package select;

import sort.Sort;

/**
 * 选择排序
 */
public class Select implements Sort {

    @Override
    public int[] sort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            int minIndex = i;
            for (int j = i; j < args.length -1; j++) {
                if (args[minIndex] > args[j + 1]) {
                    minIndex = j + 1;
                }
            }
            int temp = args[minIndex];
            args[minIndex] = args[i];
            args[i] = temp;
        }
        return args;
    }
}
