package baekjoon.math.gold;

/*
    백준 코딩 테스트 준비 - 기초
    [Gold4] 17425 약수의 합 (https://www.acmicpc.net/problem/17425)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17425 {
    static final int maxN = 1000001;
    static int T;
    static long[] dp = new long[maxN];

    public static void main(String[] args) throws IOException {
        solution();
        output();
    }

    static void solution() {
        for (int i = 1; i < maxN; i++) {
            for (int j = 1; i * j < maxN; j++) {
                dp[i * j] += i;
            }
            // i이하 수의 약수의 합들의 합 구하기
            dp[i] += dp[i - 1];
        }
    }

    static void output() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }
}
