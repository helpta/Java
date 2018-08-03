package sort;

import static sort.SortUtils.*;


/**
 * @author dpunosevac
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SortAlgorithm
 *
 * 希尔排序
 *
 *       ①希尔排序算法也属于插入排序，它是基于以下因素提出来的：当待排序列不是很大时，用直接插入排序并不怎么复杂。同时，当初始序列基本有序时，直接插入只需经过少量的比较即可完成排序。
 *       ②希尔排序将待排序列按照某个增量分成若干个子序列，分别对每个子序列用直接插入排序算法时行排序。增量的选取对希尔排序算法的时间复杂度影响很大。进行 完一趟排序之后，增量就缩小一下。因此，希尔排序也称缩小增量排序。最后一趟排序时，增量缩小为 1 ，即最后一趟排序相当于直接插入排序。
 *       ③希尔排序是不稳定的，因为元素之间的比较是各个子序列中的元素比较。相对于整个待排序列而言，某一个元素可能会跳跃性地移动。
 */
public class ShellSort implements SortAlgorithm {

  /**
   * This method implements Generic Shell Sort.
   * @param array The array to be sorted
   */
  @Override
  public <T extends Comparable<T>> T[] sort(T[] array) {
    int arrayLength = array.length;
    int h = 1;

    //如果h小于总长度的三分之一（根据初始值来看，也是判断总长度大于3）
    while (h < arrayLength/3) {
        //如果总长度大于3，h从4开始
        h = 3 * h + 1;
    }

    while (h >= 1) {
        for (int i = h; i < arrayLength; i++) {
            for (int j = i; j >= h && less(array[j], array[j-h]); j -= h) {
                swap(array, j, j - h);
            }
        }

        h /= 3;
    }

    return array;
  }

  public static void main(String[] args) {
      Integer[] toSort = {4, 23, 6, 78, 1, 54, 231, 9, 12};

      ShellSort sort = new ShellSort();
      Integer[] sorted = sort.sort(toSort);

      print(sorted);

  }
}
