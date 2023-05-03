package src.algorithm_basics.week1.sort;

import java.util.Arrays;

/*
    퀵 정렬 (Quick Sort)
    설명: 분할 정복(divide and conquer) 방법 을 통해 주어진 배열을 정렬하는 알고리즘
    * 분할 정복: 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 전략

    시간 복잡도: O(n^2) - 최악, O(nlog₂n) - 최선
    공간 복잡도: O(n)

    장점
    - 불필요한 데이터의 이동을 줄이고 먼 거리의 데이터를 교환할 뿐만 아니라, 한 번 결정된 피벗들이 추후 연산에서 제외되는 특성 때문에, 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
    - 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않는다.

    단점
    - 불안정 정렬(Unstable Sort) 이다.
    - 정렬된 배열에 대해서는 Quick Sort의 불균형 분할에 의해 오히려 수행시간이 더 많이 걸린다.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 9, 2, 4, 7};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int newPivot = partition(arr, left, right);

        if (left < newPivot - 1) {
            sort(arr, left, newPivot - 1);

        }

        if (newPivot < right) {
            sort(arr, newPivot, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);

                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }
}
