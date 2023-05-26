package src.algorithm_study.week11;
/*
    [Gold4] 백준 9252 LCS 2 (https://www.acmicpc.net/problem/9252)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252 {
    static char[] s1, s2;
    static int s1Len, s2Len;
    static int[][] dp;
    static StringBuilder sb;

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

        findLcs();
    }

    static void findLcs() {
        sb = new StringBuilder();

        int x = s1Len;
        int y = s2Len;

        while (x != 0 && y != 0) {
            // 문자가 같으면
            if (s1[x - 1] == s2[y - 1]) {
                sb.append(s1[x - 1]);
                x -= 1;
                y -= 1;
                continue;
            }

            // 윗 값과 같다
            if (dp[x - 1][y] == dp[x][y]) {
                x -= 1;
            }
            // 왼쪽 값과 같다
            else {
                y -= 1;
            }
        }
    }

    static void output() {
        System.out.println(dp[s1Len][s2Len]);

        if (dp[s1Len][s2Len] != 0) {
            System.out.println(sb.reverse());
        }
    }
}
