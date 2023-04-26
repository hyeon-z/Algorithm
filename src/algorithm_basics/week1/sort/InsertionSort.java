package src.algorithm_basics.week1.sort;

import java.util.Arrays;

/*
    삽입 정렬 (Insertion Sort)
    설명: 현재 비교하고자 하는 원소와 그 이전의 원소들과 비교하며 자리를 교환하는 알고리즘

    시간 복잡도: O(n^2) - 최악, O(n) - 최선
    공간 복잡도: O(n)

    장점
    - 알고리즘이 단순하다.
    - 대부분의 원소가 이미 정렬되어 있는 경우, 매우 효율적일 수 있다.
    - 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않는다. => 제자리 정렬(in-place sorting)
    - 동일한 값을 지니는 경우에 원소들의 본래 순서가 유지되므로, 안정 정렬(Stable Sort) 이다.
    - Selection Sort나 Bubble Sort과 같은 O(n^2) 알고리즘에 비교하여 상대적으로 빠르다.

    단점
    - 평균과 최악의 시간복잡도가 O(n^2)으로 비효율적이다.
    - Bubble Sort와 Selection Sort와 마찬가지로, 배열의 길이가 길어질수록 비효율적이다.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};

        sort(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int target = arr[i];
            int prevIndex = i - 1;

            // target의 자리를 찾는 과정
            while ((prevIndex >= 0) && (arr[prevIndex] > target)) {
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex--;
            }

            arr[prevIndex + 1] = target;
        }

        System.out.println(Arrays.toString(arr));
    }
}
