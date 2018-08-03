package sort;

import static sort.SortUtils.*;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 *
 * 快速排序算法
 *
 *      基本思路：快排中设置了三个指针，low、high、pivot。low 指向第一个元素，high 指向最后一个元素，pivot 指向枢轴元素。首先，从high 指针所指的元素开始，若它比枢轴元素要小，则与枢轴元素交换，否则 high－－ 继续与枢轴元素比较；若 high 所指元素与枢轴元素交换后，则接着将 low 所指元素与枢轴元素比较，若它比枢轴元素小则 low＋＋，否则将 low 所指元素与枢轴元素交换。
 *        ①快排的一个关键因素是选好枢轴，它进行一趟排序后，枢轴元素在表中的位置被唯一确定下来，且枢轴元素将待排序列分成两个子序列，左边的序列中的元素都比 枢轴元素小，右边的序列都比枢轴元素大。然后，分别在左右序列中选择枢轴元素再开始排序，因而，快排中包含了递归。
 *       ②当待排的元素初始有序时，快排的性能大大地下降。因为此时枢轴划分的子序列严重地不对称（一般选择第一个元素作为枢轴记录），快排退化为冒泡排序。
 *       ③快排是不稳定的，因为在排序过程中，设置了两个指针 low 和 high 。首先从high 开始自减，寻找第一个比枢轴小的元素，并将之与枢轴记录进行交换，这种跳跃式的交换可能会造成元素的相对位置的改变。
 *      ④对于快排而言，元素的初始序列与排序的趟数和比较次数是有关的。但是，平均情况下，对于内部排序而言，快排的性能是最好。平均时间复杂度为 O（n^2)，空间复杂度为O（logn）。
 */
class QuickSort implements SortAlgorithm {


    /**
     * This method implements the Generic Quick Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }


    /**
     * The sorting process
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     * @param array The array to be sorted
     **/

    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    /**
     * This method finds the partition index for an array
     *
     * @param array The array to be sorted
     * @param left  The first index of an array
     * @param right The last index of an array
     *              Finds the partition index of an array
     **/

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while (left <= right) {
            while (less(array[left], pivot)) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                if (!equal(array[left] , array[right])) {
                    swap(array, left, right);
                }
                ++left;
                --right;
            }
        }
        return left;
    }

    // Driver Program
    public static void main(String[] args) {

        // For integer input
        Integer[] array = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        //Output => 0 1 1 2 2 3 4 5 5 5 7 8 9 12 32 44 111
        print(array);

        String[] stringArray = {"c", "a", "e", "b", "d"};
        quickSort.sort(stringArray);

        //Output => a	b	c	d	e
        print(stringArray);
    }
}

