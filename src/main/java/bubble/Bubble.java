package bubble;

import sort.Sort;

public class Bubble implements Sort {

    @Override
    public void sort(int[] args) {
        int length = args.length;
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (args[j + 1] < args[j]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
    }
}
