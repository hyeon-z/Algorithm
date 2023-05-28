package baekjoon.bruteforce.silver;

/*
    백준 코딩 테스트 준비 - 기초 (브루트 포스)
    [Silver2] 3085 사탕 게임 (https://www.acmicpc.net/problem/3085)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {

    static char[][] map;
    static int N;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j);
            }
        }
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽 swap
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    search();
                    swap(i, j + 1, i, j);
                }

                // 아래쪽 swap
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    search();
                    swap(i + 1, j, i, j);
                }
            }
        }
    }

    // (x1, y1)과 (x2, y2) 교환
    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x2][y2];

        map[x2][y2] = map[x1][y1];
        map[x1][y1] = tmp;
    }

    // 가장 긴 연속 부분 탐색
    static void search() {

        // 행
        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }


        // 열
        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    static void output() {
        System.out.println(max);
    }
}
