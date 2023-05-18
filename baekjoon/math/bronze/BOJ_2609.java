package baekjoon.math.bronze;

/*
    백준 코딩 테스트 준비 - 기초
    [Bronze1] 2609 최대공약수와 최소공배수 (https://www.acmicpc.net/problem/2609)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
    static int a, b;
    static int gcd;
    static int lcm;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        gcd = gcd(a, b);
        lcm = a * b / gcd;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static void output() {
        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append("\n");
        sb.append(lcm).append("\n");

        System.out.println(sb);
    }
}
