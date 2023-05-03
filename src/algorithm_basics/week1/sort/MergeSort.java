package src.algorithm_basics.week1.sort;

import java.util.Arrays;

/*
    병합 정렬 (Merge Sort)
    설명: 분할 정복(divide and conquer) 방법 을 통해 주어진 배열을 정렬하는 알고리즘
    * 분할 정복: 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 전략

    시간 복잡도: O(nlog₂n) - 최악, O(nlog₂n) - 최선
    공간 복잡도: O(n)

    장점
    - 정렬은 데이터의 분포에 따라 최악의 경우 O(n^2)의 시간 복잡도를 갖는데 병합 정렬은 O(nlogn)의 시간 복잡도를 보장한다

    단점
    - 데이터가 배열로 구성된 경우 임시 배열이 필요하므로 추가 공간이 필요하다. → 추가 공간을 사용하므로 제자리 정렬이 아니다
    - 데이터의 크기가 큰 경우 이동 횟수가 많으므로 시간 낭비 발생
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 9, 2, 4, 7};
        int[] tmp = new int[arr.length];

        sort(arr, tmp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(arr, tmp, left, mid);
            sort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, mid, right);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }

        int part1 = left;
        int part2 = mid + 1;
        int index = left;

        while (part1 <= mid && part2 <= right) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        // 데이터가 남은 경우
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}
