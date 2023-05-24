package baekjoon.math.silver;

/*
    백준 코딩 테스트 준비 - 기초
    [Silver1] 6588 골드바흐의 추측 (https://www.acmicpc.net/problem/6588)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    static int maxN = 1000000;
    static boolean[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        findPrimeNum();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            solution(n);
        }
    }

    static void solution(int n) {
        int result = findResult(n);

        if (result == -1) {
            sb.append("Goldbach's conjecture is wrong.").append("\n");
        } else {
            sb.append(n).append(" = ").append(result).append(" + ").append(n - result).append("\n");
        }
    }

    static int findResult(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (!arr[i] && !arr[n - i]) {
                return i;
            }
        }
        return -1;
    }

    static void findPrimeNum() {
        arr = new boolean[maxN];  // index: max - 1까지

        for (int i = 2; i <= Math.sqrt(maxN); i++) {
            if (arr[i]) {
                continue;
            }

            for (int j = i * i; j < maxN; j += i) {
                arr[j] = true;
            }
        }
    }

    static void output() {
        System.out.println(sb);
    }
}
