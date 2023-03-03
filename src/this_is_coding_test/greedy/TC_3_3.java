package src.this_is_coding_test.greedy;

import java.io.IOException;
import java.util.Scanner;

/*
    이것이 코딩테스트다 3-3
    1이 될 때까지 (https://hyeon-z.tistory.com/3)

    # 시간 제한
    1초

    # 문제
    어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
    단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.

    1. N에서 1을 뺀다.
    2. N을 K로 나눈다.

    예를 들어 N이 17, K가 4라고 가정하자. 이때 1번의 과정을 한 번 수행하면 N은 16이 된다.
    이후에 2번의 과정을 두 번 수행하면 N은 1이 된다.
    결과적으로 이 경우 전체 과정을 실행한 횟수는 3이 된다. 이는 N을 1로 만드는 최소 횟수이다.
    N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하시오.

    # 입력
    첫째 줄에 N(2 <= N <= 100.000)과 K(2 <= K <= 100.000)가 공백으로 구분되며 각각 자연수로 주어진다. 이때 입력으로 주어지는 N은 항상 K보다 크거나 같다.

    # 출력
    첫째 줄에 N이 1 이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 횟수의 최솟값을 출력한다.
 */

public class TC_3_3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        while (N >= K) {
            int target = (N / K) * K;
            count += (N - target);
            N = target;

            N /= K;
            count += 1;
        }
        count += (N - 1);

        System.out.println(count);
    }
}