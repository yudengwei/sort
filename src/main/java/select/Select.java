package select;

import sort.Sort;

public class Select implements Sort {

    @Override
    public void sort(int[] args) {
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
    }
}
