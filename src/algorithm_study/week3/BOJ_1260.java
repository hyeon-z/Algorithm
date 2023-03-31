package src.algorithm_study.week3;

/*
    백준 1260 DFS와 BFS (https://www.acmicpc.net/problem/1260)

    # 시간 제한
    2초

    # 문제
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    정점 번호는 1번부터 N번까지이다.

    # 입력
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

    # 출력
    첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 그래프 생성 후 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접리스트 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        // 정점 번호 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");

        for (int i = 0; i < graph.get(x).size(); i++) {
            int node = graph.get(x).get(i);

            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int x) {
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int i = 0; i < graph.get(node).size(); i++) {
                int linkedNode = graph.get(node).get(i);

                if (!visited[linkedNode]) {
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }
}
