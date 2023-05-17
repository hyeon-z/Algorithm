package baekjoon.math.silver;

/*
    백준 코딩 테스트 준비 - 기초
    [Silver2] 17427 약수의 합2 (https://www.acmicpc.net/problem/17427)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17427 {
    static int N;
    static long result;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void solution() {
        for (int i = 1; i <= N; i++) {
            result += (long) i * (N / i);
        }
    }

    static void output() {
        System.out.println(result);
    }
}
