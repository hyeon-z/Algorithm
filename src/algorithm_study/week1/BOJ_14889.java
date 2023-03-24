package src.algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    백준 14889 스타트와 링크 (https://www.acmicpc.net/problem/14889)

    # 시간 제한
    2초

    # 문제
    오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다.

    축구는 평일 오후에 하고 의무 참석도 아니다.
    축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다.

    이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
    BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다.

    능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다.
    팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다.
    Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때,
    팀에 더해지는 능력치는 Sij와 Sji이다.

    # 입력
    첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다.
    각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다.
    Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.

    # 출력
    첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.
 */

public class BOJ_14889 {
    static int N, min;
    static int[][] ability;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        // 능력치 배열 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 스타트팀과 링크팀이 대칭되는 경우 제외
        visited[0] = true;
        comb(1, 1);

        System.out.println(min);
    }

    static void comb(int start, int depth) {
        if (depth == N / 2) {
            diff();
        } else {
            for (int i = start; i < N; i++) {
                visited[i] = true;
                comb(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int end = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += ability[i][j] + ability[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    end += ability[i][j] + ability[j][i];
                }
            }
        }

        int val = Math.abs(start - end);

        // 능력치의 차이가 0이면 무조건 최솟값이므로 종료
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }
}
