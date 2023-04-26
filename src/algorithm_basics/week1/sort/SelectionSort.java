package src.algorithm_basics.week1.sort;

import java.util.Arrays;

/*
    선택 정렬 (Selection Sort)
    설명: 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘

    시간 복잡도: O(n^2)
    공간 복잡도: O(n)

    장점
    - Bubble sort와 마찬가지로 알고리즘이 단순하다.
    - 정렬을 위한 비교 횟수는 많지만, Bubble Sort에 비해 실제로 교환하는 횟수는 적기 때문에 많은 교환이 일어나야 하는 자료상태에서 비교적 효율적이다.
    - Bubble Sort와 마찬가지로 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않는다. => 제자리 정렬(in-place sorting)

    단점
    - 시간복잡도가 O(n^2)으로, 비효율적이다.
    - 동일한 값을 지니는 경우에 원소들의 본래 순서가 유지되지 않음으로, 불안정 정렬(Unstable Sort) 이다.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 1};

        sort(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int minIndex;

        for (int i = 0; i < n - 1; i++) {
            minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }
}
