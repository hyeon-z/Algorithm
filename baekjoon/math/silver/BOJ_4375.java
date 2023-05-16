package baekjoon.math.silver;

/*
    백준 코딩 테스트 준비 - 기초
    [Silver3] 4375 1 (https://www.acmicpc.net/problem/4375)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            try {
                int n = Integer.parseInt(br.readLine());

                int cnt = 1;
                int prev = 1;

                while ((prev = prev % n) != 0) {
                    cnt++;
                    prev = prev * 10 + 1;
                }
                sb.append(cnt).append("\n");
            } catch (Exception e) {
                break;
            }
        }

        System.out.println(sb);
    }
}
