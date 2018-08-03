package sort;

import static sort.SortUtils.*;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 *
 * 冒泡排序：临近两个元素比较，最小的或者最大的一直往前替换，如果不需要替换，循环下一个元素继续类似替换，到最后最小或者最大的元素就在一头，
 * 一轮结束后，循环的元素可以减少一个，然后继续类似这样遍历，直到再没有元素替换发生。
 *
 * 冒泡排序
 *        冒泡排序的思想是：相邻两个元素的比较，将小的调到前头。因此，进行完第一趟排序，就会唯一确定出最大元素，进行完第二趟排序，就会唯一确定出次最大元素……
 *        ①由于它是基于相邻两个元素之间的比较，因此算法是稳定的。
 *        ②当元素初始序列有序时，在一趟冒泡过程中只需进行 N－1 次比较，没有进行交换操作即可完成排序。
 *        ③当初始序列逆序时，第一趟比较 N－1 次选出最大元素，第二趟比较 N－2 次选出 次最大元素……冒泡法的平均时间复杂度为 O（n^2）。
 */

class BubbleSort implements SortAlgorithm {
    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in decreasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T array[]) {
        int last = array.length;
        //Sorting
        boolean swap;
        do {
            swap = false;
            for (int count = 0; count < last - 1; count++) {
                if (less(array[count], array[count + 1])) {
                    swap = swap(array, count, count + 1);
                }
            }
            last--;
        } while (swap);
        return array;
    }

    // Driver Program
    public static void main(String[] args) {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));

    }
}
