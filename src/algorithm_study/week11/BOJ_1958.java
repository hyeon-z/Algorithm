package src.algorithm_study.week11;
/*
    [Gold3] 백준 1958 LCS 3 (https://www.acmicpc.net/problem/1958)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1958 {
    static char[] s1, s2, s3;
    static int s1Len, s2Len, s3Len;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        s3 = br.readLine().toCharArray();

        s1Len = s1.length;
        s2Len = s2.length;
        s3Len = s3.length;
    }

    static void solution() {
        dp = new int[s1Len + 1][s2Len + 1][s3Len + 1];

        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                for (int k = 1; k <= s3Len; k++) {
                    if (s1[i - 1] == s2[j - 1] && s2[j - 1] == s3[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        continue;
                    }

                    dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }
    }

    static void output() {
        System.out.println(dp[s1Len][s2Len][s3Len]);
    }
}
