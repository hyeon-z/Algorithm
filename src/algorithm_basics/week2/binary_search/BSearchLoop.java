package src.algorithm_basics.week2.binary_search;

public class BSearchLoop {
    static int[] arr = {0, 1, 2, 3, 4, 5, 6};
    static int target = 1;

    public static void main(String[] args) {
        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
