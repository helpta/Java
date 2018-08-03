package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.print;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 *
 * 直接插入排序
 *         总体思路：位于表中后面的元素依次与表中前面的元素比较，若比之小，则还需继续和更前面的元素比较，直至遇到一个比它大的元素或者比较到第一个元素(哨兵)了。
 *
 *          ①先将第一个元素视为有序，第二个元素与第一个元素比较，若比第一个元素小，则插入到第一个元素之前。第三个元素依次与第二个元素、第一个元素比较（前三 个元素有序）；第四个元素依次与第三个、第二个、第一个元素比较，插入到合适位置以形成一个有序表（即此时前四个元素有序）因此，直接插入排序算法是逐步 地形成一个有序序列的。也即在表的前头形成一个局部有序序列。
 *         ②不论初始序列如何，总需要 N－1 趟排序，第一趟是第二个元素与第一个元素比，第二趟是第三个元素与前二个元素比，第三趟是第四个元素与前三个元素比……
 *         ③当初始序列有序时，第一趟只需比较一次，第二趟只需比较一次，第三趟也只需比较一次……总共只需比较 N－1 次即可完成排序。当初始序列逆序时，第一趟比较一次，第二趟比较二次，……第 N－1 趟比较 N－1 次。总共比较 n(n-1)/2 次。
 *        ④直接插入排列是基于明确的相邻位置的两个元素的比较，因此该算法是稳定的。排序过程的比较次数与待排序列的初始状态有关。每进行一趟排列并不能唯一地确定下一个元素的最终位置。
 */

class InsertionSort implements SortAlgorithm {

    /**
     * This method implements the Generic Insertion Sort
     * Sorts the array in increasing order
     *
     * @param array The array to be sorted
     *
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int j = 1; j < array.length; j++) {

            // Picking up the key(Card)
            T key = array[j];
            int i = j - 1;

            while (i >= 0 && less(key, array[i])) {
                array[i + 1] = array[i];
                i--;
            }
            // Placing the key (Card) at its correct position in the sorted subarray
            array[i + 1] = key;
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        InsertionSort sort = new InsertionSort();

        sort.sort(integers);

        // Output => 1 4 6 9 12 23 54 78 231
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};

        sort.sort(strings);

        //Output => a	b	c	d	e
        print(strings);
    }
}
