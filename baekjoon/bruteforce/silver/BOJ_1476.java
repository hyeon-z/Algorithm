package baekjoon.bruteforce.silver;

/*
    백준 코딩 테스트 준비 - 기초 (브루트 포스)
    [Silver5] 1476 날짜 계산 (https://www.acmicpc.net/problem/1476)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {

    static int E, S, M;
    static int year;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        int e = 0, s = 0, m = 0;

        while (e != E || s != S || m != M) {
            e++;
            s++;
            m++;
            year++;

            if (e == 16) {
                e = 1;
            }

            if (s == 29) {
                s = 1;
            }

            if (m == 20) {
                m = 1;
            }
        }
    }

    static void output() {
        System.out.println(year);
    }
}
