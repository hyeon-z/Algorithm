package src.algorithm_basics.week2.binary_search;

public class BSearchRecursion {
    static int[] arr = {0, 1, 2, 3, 4, 5, 6};
    static int target = 1;

    public static void main(String[] args) {
        System.out.println(binarySearch(0, arr.length - 1));
    }

    static int binarySearch(int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(start, mid - 1);
        } else {
            return binarySearch(mid + 1, end);
        }
    }
}
