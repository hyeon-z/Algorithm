package baekjoon.math.silver;

/*
    백준 코딩 테스트 준비 - 기초
    [Silver3] 1929 소수 구하기 (https://www.acmicpc.net/problem/1929)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    static int M, N;
    static final int max = 1000000;
    static boolean[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
    }

    // 소수인지 판별하는 동시에 변수 출력
    static void solution() {
        arr = new boolean[max + 1];

        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                continue;
            }

            for (int j = 2 * i; j <= N; j += i) {
                arr[j] = true;
            }

            if (i >= M) {
                sb.append(i).append("\n");
            }
        }
    }

    static void output() {
        System.out.println(sb);
    }
}
