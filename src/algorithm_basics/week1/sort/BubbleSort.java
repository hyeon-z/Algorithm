package src.algorithm_basics.week1.sort;

import java.util.Arrays;

/*
    거품 정렬 (Bubble Sort)
    설명: 서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬하는 알고리즘

    시간 복잡도: O(n^2)
    공간 복잡도: O(n)

    장점
    - 구현이 매우 간단하고, 소스코드가 직관적이다.
    - 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않다. => 제자리 정렬(in-place sorting)
    - 동일한 값을 지니는 경우에 원소들의 본래 순서가 유지되므로, 안정 정렬(Stable Sort) 이다.

    단점
    - 시간복잡도가 최악, 최선, 평균 모두 O(n^2)으로, 굉장히 비효율적이다.
    - 정렬 되어있지 않은 원소가 정렬 됐을때의 자리로 가기 위해서, 교환 연산(swap)이 많이 일어나게 된다.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};

        sort(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // swap
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
