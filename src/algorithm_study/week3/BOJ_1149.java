package src.algorithm_study.week3;

/*
    백준 1149 RGB 거리 (https://www.acmicpc.net/problem/1149)

    # 시간 제한
    0.5초

    # 문제
    RGB 거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

    집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
    각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
    - 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    - N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    - i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    # 입력
    첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
    집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

    # 출력
    첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            dp[i][RED] = Integer.parseInt(st.nextToken());
            dp[i][GREEN] = Integer.parseInt(st.nextToken());
            dp[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i < N; i++) {
            dp[i][RED] += Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]);
            dp[i][GREEN] += Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
            dp[i][BLUE] += Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
        }

        int result = Math.min(dp[N - 1][RED], Math.min(dp[N - 1][GREEN], dp[N - 1][BLUE]));
        System.out.println(result);
    }
}
