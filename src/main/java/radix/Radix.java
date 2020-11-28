package radix;

import sort.Sort;

import java.util.ArrayList;

/**
 * 基数排序
 */
public class Radix implements Sort {

    @Override
    public int[] sort(int[] args) {
        if (args == null || args.length < 2)
            return args;
        // 1.先算出最大数的位数；
        int max = args[0];
        for (int i = 1; i < args.length; i++) {
            max = Math.max(max, args[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < args.length; j++) {
                int num = (args[j] % mod) / div;
                bucketList.get(num).add(args[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    args[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return args;
    }
}
