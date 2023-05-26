package src.algorithm_study.week11;
/*
    [Gold5] 백준 9251 LCS (https://www.acmicpc.net/problem/9251)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    static char[] s1, s2;
    static int s1Len, s2Len;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();

        s1Len = s1.length;
        s2Len = s2.length;
    }

    static void solution() {
        dp = new int[s1Len + 1][s2Len + 1];

        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    static void output() {
        System.out.println(dp[s1Len][s2Len]);
    }
}
