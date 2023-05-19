package src.algorithm_study.week10;
/*
    [Gold5] 백준 13023 ABCDE (https://www.acmicpc.net/problem/13023)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 인전 행렬로 간선정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 1);

            if (result == 1) {
                break;
            }
        }
    }

    static void dfs(int x, int depth) {
        // 친구 관계를 만족했다면 종료
        if (depth == 5) {
            result = 1;
            return;
        }

        // 방문 처리
        visited[x] = true;

        for (int i = 0; i < graph.get(x).size(); i++) {
            int num = graph.get(x).get(i);

            if (!visited[num]) {
                dfs(num, depth + 1);
            }
        }

        // 일직선이 아닐 경우, 뱡문한 지점 false 처리
        visited[x] = false;
    }

    static void output() {
        System.out.println(result);
    }
}
