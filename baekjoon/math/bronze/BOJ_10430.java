package baekjoon.math.bronze;

/*
    백준 코딩 테스트 준비 - 기초
    [Bronze5] 10430 나머지 (https://www.acmicpc.net/problem/10430)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10430 {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static void output() {
        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println(((A * B) % C));
        System.out.println(((A % C) * (B % C)) % C);
    }
}
