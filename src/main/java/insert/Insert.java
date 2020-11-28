package insert;

import sort.Sort;

/**
 * 插入排序
 */
public class Insert implements Sort {

    @Override
    public int[] sort(int[] args) {
        int current;
        for (int i = 0; i < args.length -1; i++) {
            current = args[i + 1];
            int before = i;
            while (before >= 0 && current < args[before]) {
                args[before + 1] = args[before];
                before--;
            }
            args[before + 1] = current;
        }
        return args;
    }
}
