package baekjoon.math.bronze;

/*
    백준 코딩 테스트 준비 - 기초
    [Bronze2] 1978 소수 찾기 (https://www.acmicpc.net/problem/1978)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    static int N;
    static int maxN = 1000;
    static boolean[] arr = new boolean[maxN + 1];

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        solution();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!arr[num]) {
                cnt++;
            }
        }

        output(cnt);
    }

    // 에라토스테네스의 체를 통한 풀이
    static void solution() {
        arr[1] = true;

        for (int i = 2; i <= Math.sqrt(maxN); i++) {
            if (arr[i]) {
                continue;
            }

            for (int j = i * i; j <= maxN; j += i) {
                arr[j] = true;
            }
        }
    }

    static void output(int cnt) {
        System.out.println(cnt);
    }
}
