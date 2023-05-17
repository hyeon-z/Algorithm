package baekjoon.math.bronze;

/*
    백준 코딩 테스트 준비 - 기초
    [Bronze1] 1037 약수 (https://www.acmicpc.net/problem/1037)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1037 {
    static int N;
    static int max, min = 1000001;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
    }

    static void output() {
        System.out.println(min * max);
    }
}
