package src.this_is_coding_test.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    이것이 코딩테스트다 3-1
    큰 수의 법칙(https://hyeon-z.tistory.com/1)

    # 시간 제한
    1초

    # 문제
    ‘큰 수의 법칙’은 일반적으로 통계 분야에서 다루어지는 내용이지만 동빈이는 본인만의 방식으로 다르게 사용하고 있다.
    동빈이의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다.
    단，배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.

    예를 들어 순서대로 2, 4, 5, 4, 6으로 이루어진 배열이 있을 때 M이 8이고, K가 3이라고 가정하자.
    이 경우 특정한 인덱스의 수가 연속해서 세 번까지만 더해질 수 있으므로 큰 수의 법칙에 따른 결과는 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5인 46이 된다.
    단，서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
    예를 들어 순서 대로 3, 4, 3, 4, 3으로 이루어진 배열이 있을 때 M이 7이고，K가 2라고 가정하자.
    이 경우 두 번째 원소에 해당하는 4와 네 번째 원소에 해당하는 4를 번갈아 두 번씩 더하는 것이 가능하다.
    결과적으로 4 + 4 + 4 + 4 + 4 + 4 + 4인 28이 도출된다.
    배열의 크기 N, 숫자가 더해지는 횟수 M, 그괴고 K가 주어질 때 동빈이의 큰 수의 법칙에 따른 결과를 출력하시오.

    # 입력
    - 첫째 줄에 N(2 < N < 1,000), M(1 < M < 10,000), K(1 < K < 10,000)의자연수가 주어지며.
      각 자연수는 공백으로 구분한다.
    - 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단, 각각의 자연수는 1 이상 10,000 이하의 수로 주어진다.
    - 입력으로 주어자는 K는 항상 M보다 작거나 같다.

    # 출력
    첫째 줄에 동빈이의 큰 수의 법칙에 따라 더해진 답을 출력한다.
 */

public class TC_3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        int first = number[n - 1];  // 가장 큰 수
        int second = number[n - 2];  // 두 번째 큰 수

        int quotient = m / (k + 1);
        int remainder = m % (k + 1);
        int result = 0;

        result += quotient * (first * k + second) + remainder * first;

        System.out.println(result);
    }
}