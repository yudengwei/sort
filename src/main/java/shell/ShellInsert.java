package shell;

import sort.Sort;

/**
 * 希尔插入排序
 */
public class ShellInsert implements Sort {

    @Override
    public int[] sort(int[] args) {
        //8917235460
        //3516089475
        int length = args.length;
        int temp, gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i< length; i++) {
                temp = args[i];
                int before = i - gap;
                while (before >= 0 && args[before] > temp) {
                    args[before + gap] = args[before];
                    before -= gap;
                }
                args[before + gap] = temp;
            }
            gap /= 2;
        }
        return args;
    }
}
