package baekjoon.bruteforce.bronze;

/*
    백준 코딩 테스트 준비 - 기초 (브루트 포스)
    [Bronze1] 2309 일곱 난쟁이 (https://www.acmicpc.net/problem/2309)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
    static int[] height = new int[9];
    static int sum;
    static int index1, index2;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        Arrays.sort(height);
    }

    static void solution() {
        int diff = sum - 100;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                // index i번, j번 난쟁이 제외
                if (height[i] + height[j] == diff) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }
    }

    static void output() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            if (i == index1 || i == index2) {
                continue;
            }

            sb.append(height[i]).append("\n");
        }

        System.out.println(sb);
    }
}
