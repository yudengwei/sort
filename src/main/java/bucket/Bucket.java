package bucket;

import insert.Insert;
import sort.Sort;

import java.util.*;

/**
 * 桶排序
 */
public class Bucket implements Sort {

    @Override
    public int[] sort(int[] args) {
        bucketSort(args);
        return args;
    }

    private void bucketSort(int[] arr) {
        // 新建一个桶的集合
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // 新建一个桶，并将其添加到桶的集合中去。
            // 由于桶内元素会频繁的插入，所以选择 LinkedList 作为桶的数据结构
            buckets.add(new LinkedList<>());
        }
        // 将输入数据全部放入桶中并完成排序
        for (int data : arr) {
            insertSort(buckets.get(data), data);
        }
        // 将桶中元素全部取出来并放入 arr 中输出
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer data : bucket) {
                arr[index++] = data;
            }
        }
    }

    /**
     * 我们选择插入排序作为桶内元素排序的方法 每当有一个新元素到来时，我们都调用该方法将其插入到恰当的位置
     */
    private void insertSort(List<Integer> bucket, int data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (data <= it.next()) {
                it.previous(); // 把迭代器的位置偏移回上一个位置
                it.add(data); // 把数据插入到迭代器的当前位置
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(data); // 否则把数据插入到链表末端
        }
    }

}
